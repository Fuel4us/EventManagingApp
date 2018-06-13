package pt.isep.nsheets.shared.core.vb;

// Generated from Vb.g4 by ANTLR 4.2.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link VbParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface VbVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link VbParser#booleanAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(@NotNull VbParser.BooleanAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#idAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(@NotNull VbParser.IdAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#log}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLog(@NotNull VbParser.LogContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#stat_block_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_block_if(@NotNull VbParser.Stat_block_ifContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#end_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_method(@NotNull VbParser.End_methodContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#atomExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(@NotNull VbParser.AtomExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(@NotNull VbParser.AdditiveExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull VbParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#typeOfFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeOfFunction(@NotNull VbParser.TypeOfFunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#parExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull VbParser.ParExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#unaryMinusExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpr(@NotNull VbParser.UnaryMinusExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#while_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stat(@NotNull VbParser.While_statContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull VbParser.FunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull VbParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#init_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_method(@NotNull VbParser.Init_methodContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#if_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(@NotNull VbParser.If_statContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#condition_block_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_block_if(@NotNull VbParser.Condition_block_ifContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull VbParser.StatContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull VbParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#nameOfMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameOfMethod(@NotNull VbParser.NameOfMethodContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull VbParser.OrExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#nilAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNilAtom(@NotNull VbParser.NilAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(@NotNull VbParser.ParseContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(@NotNull VbParser.RelationalExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull VbParser.DeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#numberAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(@NotNull VbParser.NumberAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#stat_block_while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_block_while(@NotNull VbParser.Stat_block_whileContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#returnMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnMethod(@NotNull VbParser.ReturnMethodContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull VbParser.NotExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#stringAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(@NotNull VbParser.StringAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#multiplicationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(@NotNull VbParser.MultiplicationExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#powExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(@NotNull VbParser.PowExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(@NotNull VbParser.EqualityExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link VbParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull VbParser.AndExprContext ctx);
}