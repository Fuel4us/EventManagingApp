package pt.isep.nsheets.shared.core.js;
// Generated from Js.g4 by ANTLR 4.2.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JsParser}.
 */
public interface JsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JsParser#booleanAtom}.
	 * @param ctx the parse tree
	 */
	void enterBooleanAtom(@NotNull JsParser.BooleanAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#booleanAtom}.
	 * @param ctx the parse tree
	 */
	void exitBooleanAtom(@NotNull JsParser.BooleanAtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#idAtom}.
	 * @param ctx the parse tree
	 */
	void enterIdAtom(@NotNull JsParser.IdAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#idAtom}.
	 * @param ctx the parse tree
	 */
	void exitIdAtom(@NotNull JsParser.IdAtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#log}.
	 * @param ctx the parse tree
	 */
	void enterLog(@NotNull JsParser.LogContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#log}.
	 * @param ctx the parse tree
	 */
	void exitLog(@NotNull JsParser.LogContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void enterCondition_block(@NotNull JsParser.Condition_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void exitCondition_block(@NotNull JsParser.Condition_blockContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(@NotNull JsParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(@NotNull JsParser.AtomExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(@NotNull JsParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(@NotNull JsParser.AdditiveExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#parExpr}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(@NotNull JsParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#parExpr}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(@NotNull JsParser.ParExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#unaryMinusExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpr(@NotNull JsParser.UnaryMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#unaryMinusExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpr(@NotNull JsParser.UnaryMinusExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stat(@NotNull JsParser.While_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stat(@NotNull JsParser.While_statContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull JsParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull JsParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(@NotNull JsParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(@NotNull JsParser.If_statContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull JsParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull JsParser.StatContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull JsParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull JsParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(@NotNull JsParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(@NotNull JsParser.OrExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#nilAtom}.
	 * @param ctx the parse tree
	 */
	void enterNilAtom(@NotNull JsParser.NilAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#nilAtom}.
	 * @param ctx the parse tree
	 */
	void exitNilAtom(@NotNull JsParser.NilAtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(@NotNull JsParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(@NotNull JsParser.ParseContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(@NotNull JsParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(@NotNull JsParser.RelationalExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#numberAtom}.
	 * @param ctx the parse tree
	 */
	void enterNumberAtom(@NotNull JsParser.NumberAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#numberAtom}.
	 * @param ctx the parse tree
	 */
	void exitNumberAtom(@NotNull JsParser.NumberAtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(@NotNull JsParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(@NotNull JsParser.NotExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#stringAtom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(@NotNull JsParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#stringAtom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(@NotNull JsParser.StringAtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#multiplicationExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpr(@NotNull JsParser.MultiplicationExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#multiplicationExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpr(@NotNull JsParser.MultiplicationExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void enterStat_block(@NotNull JsParser.Stat_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void exitStat_block(@NotNull JsParser.Stat_blockContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#powExpr}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(@NotNull JsParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#powExpr}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(@NotNull JsParser.PowExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(@NotNull JsParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(@NotNull JsParser.EqualityExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(@NotNull JsParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(@NotNull JsParser.AndExprContext ctx);
}