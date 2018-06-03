package pt.isep.nsheets.shared.core.vb;



import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvalVisitor extends VbBaseVisitor<Value> {

    // used to compare floating point numbers
    public static final double SMALL_VALUE = 0.00000000001;

    private Map<String, Value> memory = new HashMap<>();
    private Map<String, Value> cells = new HashMap<>();

    //receives current sheet cells
    public EvalVisitor(Map<String, Value> cells) {
        this.cells = cells;
    }

    @Override
    public Value visitDeclaration(VbParser.DeclarationContext ctx) {
        String id = ctx.ID().getText();

        Value value;
        if (ctx.type().getText().equals("Integer")) {
            value = new Value(0);
            return memory.put(id, value);
        }
        if (ctx.type().getText().equals("Float")) {
            value = new Value(Double.valueOf(0));
            return memory.put(id, value);
        }

        value = new Value("");
        return memory.put(id, value);
    }

    // assignment/id overrides
    @Override
    public Value visitAssignment(VbParser.AssignmentContext ctx) {

        String id = ctx.ID().getText();
        Value value = this.visit(ctx.expr());

        if (id.startsWith("$")) {
            return cells.put(id.substring(1), value);
        }

        return memory.put(id, value);
    }

    @Override
    public Value visitIdAtom(VbParser.IdAtomContext ctx) {
        String id = ctx.getText();

        Value value;

        if (id.startsWith("$")) {
            value = cells.get(id.substring(1));
        } else {
            value = memory.get(id);
        }
        if (value == null) {
            throw new RuntimeException("no such variable: " + id);
        }
        return value;
    }

    // atom overrides
    @Override
    public Value visitStringAtom(VbParser.StringAtomContext ctx) {
        String str = ctx.getText();
        // strip quotes
        str = str.substring(1, str.length() - 1).replace("\"\"", "\"");
        return new Value(str);
    }

    @Override
    public Value visitNumberAtom(VbParser.NumberAtomContext ctx) {
        return new Value(Double.valueOf(ctx.getText()));
    }

    @Override
    public Value visitBooleanAtom(VbParser.BooleanAtomContext ctx) {
        return new Value(Boolean.valueOf(ctx.getText()));
    }

    @Override
    public Value visitNilAtom(VbParser.NilAtomContext ctx) {
        return new Value(null);
    }

    // expr overrides
    @Override
    public Value visitParExpr(VbParser.ParExprContext ctx) {
        return this.visit(ctx.expr());
    }

    @Override
    public Value visitPowExpr(VbParser.PowExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(Math.pow(left.asDouble(), right.asDouble()));
    }

    @Override
    public Value visitUnaryMinusExpr(VbParser.UnaryMinusExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(-value.asDouble());
    }

    @Override
    public Value visitNotExpr(VbParser.NotExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(!value.asBoolean());
    }

    @Override
    public Value visitMultiplicationExpr(@NotNull VbParser.MultiplicationExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case VbParser.MULT:
                return new Value(left.asDouble() * right.asDouble());
            case VbParser.DIV:
                return new Value(left.asDouble() / right.asDouble());
            case VbParser.MOD:
                return new Value(left.asDouble() % right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + VbParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitAdditiveExpr(@NotNull VbParser.AdditiveExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case VbParser.PLUS:
                return left.isDouble() && right.isDouble()
                        ? new Value(left.asDouble() + right.asDouble())
                        : new Value(left.asString() + right.asString());
            case VbParser.MINUS:
                return new Value(left.asDouble() - right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + VbParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitRelationalExpr(@NotNull VbParser.RelationalExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case VbParser.LT:
                return new Value(left.asDouble() < right.asDouble());
            case VbParser.LTEQ:
                return new Value(left.asDouble() <= right.asDouble());
            case VbParser.GT:
                return new Value(left.asDouble() > right.asDouble());
            case VbParser.GTEQ:
                return new Value(left.asDouble() >= right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + VbParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitEqualityExpr(@NotNull VbParser.EqualityExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case VbParser.EQ:
                return left.isDouble() && right.isDouble()
                        ? new Value(Math.abs(left.asDouble() - right.asDouble()) < SMALL_VALUE)
                        : new Value(left.equals(right));
            case VbParser.NEQ:
                return left.isDouble() && right.isDouble()
                        ? new Value(Math.abs(left.asDouble() - right.asDouble()) >= SMALL_VALUE)
                        : new Value(!left.equals(right));
            default:
                throw new RuntimeException("unknown operator: " + VbParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitAndExpr(VbParser.AndExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(left.asBoolean() && right.asBoolean());
    }

    @Override
    public Value visitOrExpr(VbParser.OrExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(left.asBoolean() || right.asBoolean());
    }

    // log override
    @Override
    public Value visitLog(VbParser.LogContext ctx) {
        Value value = this.visit(ctx.expr());
        System.out.println(value);
        return value;
    }

    // if override
    @Override
    public Value visitIf_stat(VbParser.If_statContext ctx) {

        List<VbParser.Condition_block_ifContext> conditions = ctx.condition_block_if();

        boolean evaluatedBlock = false;

        for (VbParser.Condition_block_ifContext condition : conditions) {

            Value evaluated = this.visit(condition.expr());

            if (evaluated.asBoolean()) {
                evaluatedBlock = true;
                // evaluate this block whose expr==true
                this.visit(condition.stat_block_if());
                break;
            }
        }

        if (!evaluatedBlock && ctx.stat_block_if() != null) {
            // evaluate the else-stat_block (if present == not null)
            this.visit(ctx.stat_block_if());
        }

        return Value.VOID;
    }

    // while override
    @Override
    public Value visitWhile_stat(VbParser.While_statContext ctx) {

        Value value = this.visit(ctx.expr());

        while (value.asBoolean()) {

            // evaluate the code block
            this.visit(ctx.stat_block_while());

            // evaluate the expression
            value = this.visit(ctx.expr());
        }

        return Value.VOID;
    }
}
