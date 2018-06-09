package pt.isep.nsheets.shared.core.js;

import org.antlr.v4.runtime.misc.NotNull;
import pt.isep.nsheets.shared.core.vb.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvalVisitor extends JsBaseVisitor<Value> {

    // used to compare floating point numbers
    private static final double SMALL_VALUE = 0.00000000001;

    private Map<String, Value> memory = new HashMap<>();
    private Map<String, Value> cells;
    private String output = "";

    //receives current sheet cells
    public EvalVisitor(Map<String, Value> cells) {
        this.cells = cells;
    }

    @Override
    public Value visitAssignment(JsParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();
        Value value;

        if(this.visit(ctx.expr()).isDouble())
            value = new Value(this.visit(ctx.expr()).asDouble());
        else
            value = new Value(this.visit(ctx.expr()).asString());

        if (id.startsWith("$"))
            return cells.put(id.substring(1), value);
        return memory.put(id, value);
    }

    @Override
    public Value visitIdAtom(JsParser.IdAtomContext ctx) {
        String id = ctx.getText();
        Value value;
        if (id.startsWith("$")) {
            value = cells.get(id.substring(1));
        } else {
            value = memory.get(id);
        }
        if(value == null) {
            throw new RuntimeException("no such variable: " + id);
        }
        return value;
    }

    // atom overrides
    @Override
    public Value visitStringAtom(JsParser.StringAtomContext ctx) {
        String str = ctx.getText();
        // strip quotes
        str = str.substring(1, str.length() - 1).replace("\"\"", "\"");
        return new Value(str);
    }

    @Override
    public Value visitNumberAtom(JsParser.NumberAtomContext ctx) {
        return new Value(Double.valueOf(ctx.getText()));
    }

    @Override
    public Value visitBooleanAtom(JsParser.BooleanAtomContext ctx) {
        return new Value(Boolean.valueOf(ctx.getText()));
    }

    @Override
    public Value visitNilAtom(JsParser.NilAtomContext ctx) {
        return new Value(null);
    }

    // expr overrides
    @Override
    public Value visitParExpr(JsParser.ParExprContext ctx) {
        return this.visit(ctx.expr());
    }

    @Override
    public Value visitPowExpr(JsParser.PowExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(Math.pow(left.asDouble(), right.asDouble()));
    }

    @Override
    public Value visitUnaryMinusExpr(JsParser.UnaryMinusExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(-value.asDouble());
    }

    @Override
    public Value visitNotExpr(JsParser.NotExprContext ctx) {
        Value value = this.visit(ctx.expr());
        return new Value(!value.asBoolean());
    }

    @Override
    public Value visitMultiplicationExpr(@NotNull JsParser.MultiplicationExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case JsParser.MULT:
                return new Value(left.asDouble() * right.asDouble());
            case JsParser.DIV:
                return new Value(left.asDouble() / right.asDouble());
            case JsParser.MOD:
                return new Value(left.asDouble() % right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + JsParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitAdditiveExpr(@NotNull JsParser.AdditiveExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case JsParser.PLUS:
                return left.isDouble() && right.isDouble() ?
                        new Value(left.asDouble() + right.asDouble()) :
                        new Value(left.asString() + right.asString());
            case JsParser.MINUS:
                return new Value(left.asDouble() - right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + JsParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitRelationalExpr(@NotNull JsParser.RelationalExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case JsParser.LT:
                return new Value(left.asDouble() < right.asDouble());
            case JsParser.LTEQ:
                return new Value(left.asDouble() <= right.asDouble());
            case JsParser.GT:
                return new Value(left.asDouble() > right.asDouble());
            case JsParser.GTEQ:
                return new Value(left.asDouble() >= right.asDouble());
            default:
                throw new RuntimeException("unknown operator: " + JsParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitEqualityExpr(@NotNull JsParser.EqualityExprContext ctx) {

        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case JsParser.EQ:
                return left.isDouble() && right.isDouble() ?
                        new Value(Math.abs(left.asDouble() - right.asDouble()) < SMALL_VALUE) :
                        new Value(left.equals(right));
            case JsParser.NEQ:
                return left.isDouble() && right.isDouble() ?
                        new Value(Math.abs(left.asDouble() - right.asDouble()) >= SMALL_VALUE) :
                        new Value(!left.equals(right));
            default:
                throw new RuntimeException("unknown operator: " + JsParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitAndExpr(JsParser.AndExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(left.asBoolean() && right.asBoolean());
    }

    @Override
    public Value visitOrExpr(JsParser.OrExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        return new Value(left.asBoolean() || right.asBoolean());
    }

    // log override
    @Override
    public Value visitLog(JsParser.LogContext ctx) {
        Value value = this.visit(ctx.expr());
        this.output += value.toString() + "\n";
        return value;
    }

    // if override
    @Override
    public Value visitIf_stat(JsParser.If_statContext ctx) {

        List<JsParser.Condition_blockContext> conditions =  ctx.condition_block();

        boolean evaluatedBlock = false;

        for(JsParser.Condition_blockContext condition : conditions) {

            Value evaluated = this.visit(condition.expr());

            if(evaluated.asBoolean()) {
                evaluatedBlock = true;
                // evaluate this block whose expr==true
                this.visit(condition.stat_block());
                break;
            }
        }

        if(!evaluatedBlock && ctx.stat_block() != null) {
            // evaluate the else-stat_block (if present == not null)
            this.visit(ctx.stat_block());
        }

        return Value.VOID;
    }

    // while override
    @Override
    public Value visitWhile_stat(JsParser.While_statContext ctx) {

        Value value = this.visit(ctx.expr());

        while(value.asBoolean()) {

            // evaluate the code block
            this.visit(ctx.stat_block());

            // evaluate the expression
            value = this.visit(ctx.expr());
        }

        return Value.VOID;
    }

    public String getOutput() {
        return output;
    }
}
