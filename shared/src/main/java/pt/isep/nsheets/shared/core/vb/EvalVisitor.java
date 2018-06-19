package pt.isep.nsheets.shared.core.vb;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.core.vb.compiler.VbBaseVisitor;
import pt.isep.nsheets.shared.core.vb.compiler.VbLexer;
import pt.isep.nsheets.shared.core.vb.compiler.VbParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvalVisitor extends VbBaseVisitor<Value> {

    // used to compare floating point numbers
    public static final double SMALL_VALUE = 0.00000000001;

    private Map<String, Value> memory = new HashMap<>();
    private Map<String, Value> functionMemory;
    private Map<String, Value> cells;
    private String output = "";

    private Map<String, Function> functions = new HashMap<>();
    Function function;

    //receives current sheet cells
    public EvalVisitor(Map<String, Value> cells) {
        this.cells = cells;
    }

    @Override
    public Value visitDeclaration(@NotNull VbParser.DeclarationContext ctx) {
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

        throw new RuntimeException("Invalid type: " + id);
    }

    // assignment/id overrides
    @Override
    public Value visitAssignment(@NotNull VbParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();
        Value value = this.visit(ctx.expr());

        if (id.startsWith("$")) {
            return cells.put(id.substring(1), value);
        }

        return memory.put(id, value);
    }

    @Override
    public Value visitIdAtom(@NotNull VbParser.IdAtomContext ctx) {
        String id = ctx.getText();
        Value value;

        if (id.startsWith("$")) {
            value = cells.get(id.substring(1));
        } else {
            value = memory.get(id);
        }

        if (value == null) {
            throw new RuntimeException("No such variable: " + id);
        }

        return value;
    }

    // atom overrides
    @Override
    public Value visitStringAtom(@NotNull VbParser.StringAtomContext ctx) {
        String str = ctx.getText();
        // strip quotes
        str = str.substring(1, str.length() - 1).replace("\"\"", "\"");

        return new Value(str);
    }

    @Override
    public Value visitNumberAtom(@NotNull VbParser.NumberAtomContext ctx) {
        return new Value(Double.valueOf(ctx.getText()));
    }

    @Override
    public Value visitBooleanAtom(@NotNull VbParser.BooleanAtomContext ctx) {
        return new Value(Boolean.valueOf(ctx.getText()));
    }

    @Override
    public Value visitNilAtom(@NotNull VbParser.NilAtomContext ctx) {
        return new Value(null);
    }

    // expr overrides
    @Override
    public Value visitParExpr(@NotNull VbParser.ParExprContext ctx) {
        return this.visit(ctx.expr());
    }

    @Override
    public Value visitPowExpr(@NotNull VbParser.PowExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        return new Value(Math.pow(left.asDouble(), right.asDouble()));
    }

    @Override
    public Value visitUnaryMinusExpr(@NotNull VbParser.UnaryMinusExprContext ctx) {
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
                throw new RuntimeException("Unknown operator: " + VbParser.tokenNames[ctx.op.getType()]);
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
                throw new RuntimeException("Unknown operator: " + VbParser.tokenNames[ctx.op.getType()]);
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
    public Value visitAndExpr(@NotNull VbParser.AndExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        return new Value(left.asBoolean() && right.asBoolean());
    }

    @Override
    public Value visitOrExpr(@NotNull VbParser.OrExprContext ctx) {
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));

        return new Value(left.asBoolean() || right.asBoolean());
    }

    // log override
    @Override
    public Value visitLog(@NotNull VbParser.LogContext ctx) {
        Value value = this.visit(ctx.expr());
        this.output += value.toString() + "\n";

        return value;
    }

    // if override
    @Override
    public Value visitIf_stat(@NotNull VbParser.If_statContext ctx) {
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
    public Value visitWhile_stat(@NotNull VbParser.While_statContext ctx) {
        Value value = this.visit(ctx.expr());

        while (value.asBoolean()) {
            // evaluate the code block
            this.visit(ctx.stat_block_while());
            // evaluate the expression
            value = this.visit(ctx.expr());
        }

        return Value.VOID;
    }

    @Override
    public Value visitFunction(@NotNull VbParser.FunctionContext ctx) {
        String functionName = ctx.initFunction().functionName().ID().getText();
        String functionBody = getText(ctx.functionBody());

        functionMemory = new HashMap<>();
        function = new Function(functionName, functionBody);
        this.functionMemory.clear();

        return this.visit(ctx.functionBody());
    }

  /*@Override
    public Value visitParametersWithoutType(@NotNull VbParser.ParametersWithoutTypeContext ctx) {
        return visit(ctx.ID());
    }

    @Override
    public Value visitParametersWithType(@NotNull VbParser.ParametersWithTypeContext ctx) {
        String id = ctx.ID().getText();
        Value value = this.visit(ctx.type());

        return functionMemory.put(id, value);
    }*/

    @Override
    public Value visitFunctionBody(@NotNull VbParser.FunctionBodyContext ctx) {
        ctx.stat().forEach((stat) -> this.visit(stat));

        return this.visit(ctx.returnFunction());
    }

    @Override
    public Value visitReturnFunction(@NotNull VbParser.ReturnFunctionContext ctx) {
        if (ctx.ID() != null) {
            return this.visit(ctx.ID());
        } else {
            return Value.VOID;
        }
    }

    @Override
    public Value visitFunctionCall(@NotNull VbParser.FunctionCallContext ctx) {
        String functionBody = function.getFunction();

        VbLexer lexer = new VbLexer(new ANTLRInputStream(functionBody));
        VbParser parser = new VbParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.block();
        Value value = this.visit(tree);

        return value;
    }

    public static String getText(ParserRuleContext ctx) {
        if (ctx.start == null || ctx.stop == null || ctx.start.getStartIndex() < 0 || ctx.stop.getStopIndex() < 0) {
            return ctx.getText();
        }
        return ctx.start.getInputStream().getText(Interval.of(ctx.start.getStartIndex(), ctx.stop.getStopIndex()));
    }

    public String getOutput() {
        return output;
    }
}
