package pt.isep.nsheets.shared.core.vb;

// Generated from Vb.g4 by ANTLR 4.2.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VbParser}.
 */
public interface VbListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VbParser#booleanAtom}.
	 * @param ctx the parse tree
	 */
	void enterBooleanAtom(@NotNull VbParser.BooleanAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#booleanAtom}.
	 * @param ctx the parse tree
	 */
	void exitBooleanAtom(@NotNull VbParser.BooleanAtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#idAtom}.
	 * @param ctx the parse tree
	 */
	void enterIdAtom(@NotNull VbParser.IdAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#idAtom}.
	 * @param ctx the parse tree
	 */
	void exitIdAtom(@NotNull VbParser.IdAtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#log}.
	 * @param ctx the parse tree
	 */
	void enterLog(@NotNull VbParser.LogContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#log}.
	 * @param ctx the parse tree
	 */
	void exitLog(@NotNull VbParser.LogContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#stat_block_if}.
	 * @param ctx the parse tree
	 */
	void enterStat_block_if(@NotNull VbParser.Stat_block_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#stat_block_if}.
	 * @param ctx the parse tree
	 */
	void exitStat_block_if(@NotNull VbParser.Stat_block_ifContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#end_method}.
	 * @param ctx the parse tree
	 */
	void enterEnd_method(@NotNull VbParser.End_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#end_method}.
	 * @param ctx the parse tree
	 */
	void exitEnd_method(@NotNull VbParser.End_methodContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(@NotNull VbParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(@NotNull VbParser.AtomExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(@NotNull VbParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(@NotNull VbParser.AdditiveExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull VbParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull VbParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#typeOfFunction}.
	 * @param ctx the parse tree
	 */
	void enterTypeOfFunction(@NotNull VbParser.TypeOfFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#typeOfFunction}.
	 * @param ctx the parse tree
	 */
	void exitTypeOfFunction(@NotNull VbParser.TypeOfFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#parExpr}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(@NotNull VbParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#parExpr}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(@NotNull VbParser.ParExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#unaryMinusExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpr(@NotNull VbParser.UnaryMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#unaryMinusExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpr(@NotNull VbParser.UnaryMinusExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stat(@NotNull VbParser.While_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stat(@NotNull VbParser.While_statContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull VbParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull VbParser.FunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull VbParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull VbParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#init_method}.
	 * @param ctx the parse tree
	 */
	void enterInit_method(@NotNull VbParser.Init_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#init_method}.
	 * @param ctx the parse tree
	 */
	void exitInit_method(@NotNull VbParser.Init_methodContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(@NotNull VbParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(@NotNull VbParser.If_statContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#condition_block_if}.
	 * @param ctx the parse tree
	 */
	void enterCondition_block_if(@NotNull VbParser.Condition_block_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#condition_block_if}.
	 * @param ctx the parse tree
	 */
	void exitCondition_block_if(@NotNull VbParser.Condition_block_ifContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull VbParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull VbParser.StatContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull VbParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull VbParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#nameOfMethod}.
	 * @param ctx the parse tree
	 */
	void enterNameOfMethod(@NotNull VbParser.NameOfMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#nameOfMethod}.
	 * @param ctx the parse tree
	 */
	void exitNameOfMethod(@NotNull VbParser.NameOfMethodContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(@NotNull VbParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(@NotNull VbParser.OrExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#nilAtom}.
	 * @param ctx the parse tree
	 */
	void enterNilAtom(@NotNull VbParser.NilAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#nilAtom}.
	 * @param ctx the parse tree
	 */
	void exitNilAtom(@NotNull VbParser.NilAtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(@NotNull VbParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(@NotNull VbParser.ParseContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(@NotNull VbParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(@NotNull VbParser.RelationalExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(@NotNull VbParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(@NotNull VbParser.DeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#numberAtom}.
	 * @param ctx the parse tree
	 */
	void enterNumberAtom(@NotNull VbParser.NumberAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#numberAtom}.
	 * @param ctx the parse tree
	 */
	void exitNumberAtom(@NotNull VbParser.NumberAtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#stat_block_while}.
	 * @param ctx the parse tree
	 */
	void enterStat_block_while(@NotNull VbParser.Stat_block_whileContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#stat_block_while}.
	 * @param ctx the parse tree
	 */
	void exitStat_block_while(@NotNull VbParser.Stat_block_whileContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#returnMethod}.
	 * @param ctx the parse tree
	 */
	void enterReturnMethod(@NotNull VbParser.ReturnMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#returnMethod}.
	 * @param ctx the parse tree
	 */
	void exitReturnMethod(@NotNull VbParser.ReturnMethodContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(@NotNull VbParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(@NotNull VbParser.NotExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#stringAtom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(@NotNull VbParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#stringAtom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(@NotNull VbParser.StringAtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#multiplicationExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpr(@NotNull VbParser.MultiplicationExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#multiplicationExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpr(@NotNull VbParser.MultiplicationExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#powExpr}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(@NotNull VbParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#powExpr}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(@NotNull VbParser.PowExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(@NotNull VbParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(@NotNull VbParser.EqualityExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link VbParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(@NotNull VbParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link VbParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(@NotNull VbParser.AndExprContext ctx);
}