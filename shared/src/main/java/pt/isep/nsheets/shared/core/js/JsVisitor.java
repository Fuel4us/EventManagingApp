package pt.isep.nsheets.shared.core.js;
// Generated from Js.g4 by ANTLR 4.2.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JsParser#booleanAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(@NotNull JsParser.BooleanAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#idAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(@NotNull JsParser.IdAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#log}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLog(@NotNull JsParser.LogContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#condition_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_block(@NotNull JsParser.Condition_blockContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#atomExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(@NotNull JsParser.AtomExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(@NotNull JsParser.AdditiveExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#parExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull JsParser.ParExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#unaryMinusExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpr(@NotNull JsParser.UnaryMinusExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#while_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stat(@NotNull JsParser.While_statContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull JsParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#if_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(@NotNull JsParser.If_statContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull JsParser.StatContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull JsParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull JsParser.OrExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#nilAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNilAtom(@NotNull JsParser.NilAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(@NotNull JsParser.ParseContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(@NotNull JsParser.RelationalExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#numberAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(@NotNull JsParser.NumberAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull JsParser.NotExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#stringAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(@NotNull JsParser.StringAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#multiplicationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(@NotNull JsParser.MultiplicationExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#stat_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_block(@NotNull JsParser.Stat_blockContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#powExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(@NotNull JsParser.PowExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(@NotNull JsParser.EqualityExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JsParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull JsParser.AndExprContext ctx);
}