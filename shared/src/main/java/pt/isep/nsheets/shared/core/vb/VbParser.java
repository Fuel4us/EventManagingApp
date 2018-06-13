package pt.isep.nsheets.shared.core.vb;

// Generated from Vb.g4 by ANTLR 4.2.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VbParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, TYPE_INT=8, TYPE_FLOAT=9, 
		TYPE_STRING=10, OR=11, AND=12, EQ=13, NEQ=14, GT=15, LT=16, GTEQ=17, LTEQ=18, 
		PLUS=19, MINUS=20, MULT=21, DIV=22, MOD=23, POW=24, NOT=25, SCOL=26, ASSIGN=27, 
		OPAR=28, CPAR=29, OPENIF=30, CLOSEIF=31, ENDWHILE=32, TRUE=33, FALSE=34, 
		NIL=35, IF=36, ELSE=37, WHILE=38, LOG=39, ID=40, INT=41, FLOAT=42, STRING=43, 
		COMMENT=44, SPACE=45, OTHER=46;
	public static final String[] tokenNames = {
		"<INVALID>", "'Return'", "'As'", "'Function'", "'Public'", "'End'", "'Private'", 
		"'Dim'", "'Integer'", "'Float'", "'String'", "'||'", "'&&'", "'=='", "'<>'", 
		"'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'^'", 
		"'!'", "';'", "'='", "'('", "')'", "'Then'", "CLOSEIF", "ENDWHILE", "'true'", 
		"'false'", "'nil'", "'If'", "'Else'", "'While'", "'Log'", "ID", "INT", 
		"FLOAT", "STRING", "COMMENT", "SPACE", "OTHER"
	};
	public static final int
		RULE_parse = 0, RULE_block = 1, RULE_function = 2, RULE_init_method = 3, 
		RULE_typeOfFunction = 4, RULE_returnMethod = 5, RULE_end_method = 6, RULE_stat = 7, 
		RULE_nameOfMethod = 8, RULE_declaration = 9, RULE_assignment = 10, RULE_if_stat = 11, 
		RULE_condition_block_if = 12, RULE_stat_block_if = 13, RULE_while_stat = 14, 
		RULE_stat_block_while = 15, RULE_log = 16, RULE_expr = 17, RULE_atom = 18, 
		RULE_type = 19;
	public static final String[] ruleNames = {
		"parse", "block", "function", "init_method", "typeOfFunction", "returnMethod", 
		"end_method", "stat", "nameOfMethod", "declaration", "assignment", "if_stat", 
		"condition_block_if", "stat_block_if", "while_stat", "stat_block_while", 
		"log", "expr", "atom", "type"
	};

	@Override
	public String getGrammarFileName() { return "Vb.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public VbParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(VbParser.EOF, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); block();
			setState(41); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			setState(55);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << IF) | (1L << WHILE) | (1L << LOG) | (1L << ID) | (1L << OTHER))) != 0)) {
					{
					{
					setState(43); stat();
					}
					}
					setState(48);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4 || _la==6) {
					{
					{
					setState(49); function();
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public End_methodContext end_method() {
			return getRuleContext(End_methodContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public ReturnMethodContext returnMethod() {
			return getRuleContext(ReturnMethodContext.class,0);
		}
		public Init_methodContext init_method() {
			return getRuleContext(Init_methodContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); init_method();
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58); stat();
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << IF) | (1L << WHILE) | (1L << LOG) | (1L << ID) | (1L << OTHER))) != 0) );
			setState(63); returnMethod();
			setState(64); end_method();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Init_methodContext extends ParserRuleContext {
		public NameOfMethodContext nameOfMethod() {
			return getRuleContext(NameOfMethodContext.class,0);
		}
		public TypeOfFunctionContext typeOfFunction() {
			return getRuleContext(TypeOfFunctionContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Init_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterInit_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitInit_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitInit_method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Init_methodContext init_method() throws RecognitionException {
		Init_methodContext _localctx = new Init_methodContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_init_method);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); typeOfFunction();
			setState(67); match(3);
			setState(68); nameOfMethod();
			setState(69); match(2);
			setState(70); type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeOfFunctionContext extends ParserRuleContext {
		public TypeOfFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeOfFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterTypeOfFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitTypeOfFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitTypeOfFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeOfFunctionContext typeOfFunction() throws RecognitionException {
		TypeOfFunctionContext _localctx = new TypeOfFunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typeOfFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_la = _input.LA(1);
			if ( !(_la==4 || _la==6) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnMethodContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(VbParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterReturnMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitReturnMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitReturnMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnMethodContext returnMethod() throws RecognitionException {
		ReturnMethodContext _localctx = new ReturnMethodContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_returnMethod);
		try {
			setState(78);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74); match(1);
				setState(75); expr(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76); match(1);
				setState(77); match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class End_methodContext extends ParserRuleContext {
		public End_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterEnd_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitEnd_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitEnd_method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final End_methodContext end_method() throws RecognitionException {
		End_methodContext _localctx = new End_methodContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_end_method);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); match(5);
			setState(81); match(3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public Token OTHER;
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public While_statContext while_stat() {
			return getRuleContext(While_statContext.class,0);
		}
		public If_statContext if_stat() {
			return getRuleContext(If_statContext.class,0);
		}
		public TerminalNode OTHER() { return getToken(VbParser.OTHER, 0); }
		public LogContext log() {
			return getRuleContext(LogContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stat);
		try {
			setState(90);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(83); assignment();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 2);
				{
				setState(84); declaration();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(85); if_stat();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(86); while_stat();
				}
				break;
			case LOG:
				enterOuterAlt(_localctx, 5);
				{
				setState(87); log();
				}
				break;
			case OTHER:
				enterOuterAlt(_localctx, 6);
				{
				setState(88); ((StatContext)_localctx).OTHER = match(OTHER);
				System.err.println("unknown char: " + (((StatContext)_localctx).OTHER!=null?((StatContext)_localctx).OTHER.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameOfMethodContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(VbParser.ID, 0); }
		public TerminalNode CPAR() { return getToken(VbParser.CPAR, 0); }
		public TerminalNode OPAR() { return getToken(VbParser.OPAR, 0); }
		public NameOfMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameOfMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterNameOfMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitNameOfMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitNameOfMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameOfMethodContext nameOfMethod() throws RecognitionException {
		NameOfMethodContext _localctx = new NameOfMethodContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_nameOfMethod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92); match(ID);
			setState(93); match(OPAR);
			setState(94); match(CPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(VbParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); match(7);
			setState(97); match(ID);
			setState(98); match(2);
			setState(99); type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(VbParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(VbParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); match(ID);
			setState(102); match(ASSIGN);
			setState(103); expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_statContext extends ParserRuleContext {
		public List<TerminalNode> ELSE() { return getTokens(VbParser.ELSE); }
		public List<TerminalNode> IF() { return getTokens(VbParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(VbParser.IF, i);
		}
		public Stat_block_ifContext stat_block_if() {
			return getRuleContext(Stat_block_ifContext.class,0);
		}
		public List<Condition_block_ifContext> condition_block_if() {
			return getRuleContexts(Condition_block_ifContext.class);
		}
		public TerminalNode ELSE(int i) {
			return getToken(VbParser.ELSE, i);
		}
		public Condition_block_ifContext condition_block_if(int i) {
			return getRuleContext(Condition_block_ifContext.class,i);
		}
		public If_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterIf_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitIf_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitIf_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statContext if_stat() throws RecognitionException {
		If_statContext _localctx = new If_statContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_if_stat);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(105); match(IF);
			setState(106); condition_block_if();
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(107); match(ELSE);
					setState(108); match(IF);
					setState(109); condition_block_if();
					}
					} 
				}
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(117);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(115); match(ELSE);
				setState(116); stat_block_if();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Condition_block_ifContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stat_block_ifContext stat_block_if() {
			return getRuleContext(Stat_block_ifContext.class,0);
		}
		public Condition_block_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition_block_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterCondition_block_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitCondition_block_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitCondition_block_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Condition_block_ifContext condition_block_if() throws RecognitionException {
		Condition_block_ifContext _localctx = new Condition_block_ifContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_condition_block_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); expr(0);
			setState(120); stat_block_if();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stat_block_ifContext extends ParserRuleContext {
		public TerminalNode OPENIF() { return getToken(VbParser.OPENIF, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode CLOSEIF() { return getToken(VbParser.CLOSEIF, 0); }
		public Stat_block_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_block_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterStat_block_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitStat_block_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitStat_block_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_block_ifContext stat_block_if() throws RecognitionException {
		Stat_block_ifContext _localctx = new Stat_block_ifContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stat_block_if);
		try {
			setState(127);
			switch (_input.LA(1)) {
			case OPENIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(122); match(OPENIF);
				setState(123); block();
				setState(124); match(CLOSEIF);
				}
				break;
			case 7:
			case IF:
			case WHILE:
			case LOG:
			case ID:
			case OTHER:
				enterOuterAlt(_localctx, 2);
				{
				setState(126); stat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_statContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(VbParser.WHILE, 0); }
		public Stat_block_whileContext stat_block_while() {
			return getRuleContext(Stat_block_whileContext.class,0);
		}
		public While_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterWhile_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitWhile_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitWhile_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_statContext while_stat() throws RecognitionException {
		While_statContext _localctx = new While_statContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_while_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(WHILE);
			setState(130); expr(0);
			setState(131); stat_block_while();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stat_block_whileContext extends ParserRuleContext {
		public TerminalNode ENDWHILE() { return getToken(VbParser.ENDWHILE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Stat_block_whileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_block_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterStat_block_while(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitStat_block_while(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitStat_block_while(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_block_whileContext stat_block_while() throws RecognitionException {
		Stat_block_whileContext _localctx = new Stat_block_whileContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_stat_block_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); block();
			setState(134); match(ENDWHILE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogContext extends ParserRuleContext {
		public TerminalNode LOG() { return getToken(VbParser.LOG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_log; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterLog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitLog(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitLog(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogContext log() throws RecognitionException {
		LogContext _localctx = new LogContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_log);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); match(LOG);
			setState(137); expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(VbParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryMinusExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(VbParser.MINUS, 0); }
		public UnaryMinusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterUnaryMinusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitUnaryMinusExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitUnaryMinusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(VbParser.MULT, 0); }
		public TerminalNode MOD() { return getToken(VbParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(VbParser.DIV, 0); }
		public MultiplicationExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterMultiplicationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitMultiplicationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitMultiplicationExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(VbParser.OR, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(VbParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(VbParser.MINUS, 0); }
		public AdditiveExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterAdditiveExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitAdditiveExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitAdditiveExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode POW() { return getToken(VbParser.POW, 0); }
		public PowExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterPowExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitPowExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitPowExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationalExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LTEQ() { return getToken(VbParser.LTEQ, 0); }
		public TerminalNode LT() { return getToken(VbParser.LT, 0); }
		public TerminalNode GT() { return getToken(VbParser.GT, 0); }
		public TerminalNode GTEQ() { return getToken(VbParser.GTEQ, 0); }
		public RelationalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterRelationalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitRelationalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitRelationalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExprContext extends ExprContext {
		public Token op;
		public TerminalNode NEQ() { return getToken(VbParser.NEQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(VbParser.EQ, 0); }
		public EqualityExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterEqualityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitEqualityExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitEqualityExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(VbParser.AND, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			switch (_input.LA(1)) {
			case MINUS:
				{
				_localctx = new UnaryMinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(140); match(MINUS);
				setState(141); expr(9);
				}
				break;
			case NOT:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142); match(NOT);
				setState(143); expr(8);
				}
				break;
			case OPAR:
			case TRUE:
			case FALSE:
			case NIL:
			case ID:
			case INT:
			case FLOAT:
			case STRING:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144); atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(168);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(147);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(148); match(POW);
						setState(149); expr(11);
						}
						break;

					case 2:
						{
						_localctx = new MultiplicationExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(150);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(151);
						((MultiplicationExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MultiplicationExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(152); expr(8);
						}
						break;

					case 3:
						{
						_localctx = new AdditiveExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(153);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(154);
						((AdditiveExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((AdditiveExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(155); expr(7);
						}
						break;

					case 4:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(156);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(157);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GTEQ) | (1L << LTEQ))) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(158); expr(6);
						}
						break;

					case 5:
						{
						_localctx = new EqualityExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(159);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(160);
						((EqualityExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(161); expr(5);
						}
						break;

					case 6:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(162);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(163); match(AND);
						setState(164); expr(4);
						}
						break;

					case 7:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(165);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(166); match(OR);
						setState(167); expr(3);
						}
						break;
					}
					} 
				}
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParExprContext extends AtomContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(VbParser.CPAR, 0); }
		public TerminalNode OPAR() { return getToken(VbParser.OPAR, 0); }
		public ParExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitParExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitParExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanAtomContext extends AtomContext {
		public TerminalNode FALSE() { return getToken(VbParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(VbParser.TRUE, 0); }
		public BooleanAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterBooleanAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitBooleanAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitBooleanAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdAtomContext extends AtomContext {
		public TerminalNode ID() { return getToken(VbParser.ID, 0); }
		public IdAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterIdAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitIdAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitIdAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringAtomContext extends AtomContext {
		public TerminalNode STRING() { return getToken(VbParser.STRING, 0); }
		public StringAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterStringAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitStringAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitStringAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NilAtomContext extends AtomContext {
		public TerminalNode NIL() { return getToken(VbParser.NIL, 0); }
		public NilAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterNilAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitNilAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitNilAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberAtomContext extends AtomContext {
		public TerminalNode INT() { return getToken(VbParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(VbParser.FLOAT, 0); }
		public NumberAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterNumberAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitNumberAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitNumberAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_atom);
		int _la;
		try {
			setState(182);
			switch (_input.LA(1)) {
			case OPAR:
				_localctx = new ParExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(173); match(OPAR);
				setState(174); expr(0);
				setState(175); match(CPAR);
				}
				break;
			case INT:
			case FLOAT:
				_localctx = new NumberAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==FLOAT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BooleanAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case ID:
				_localctx = new IdAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(179); match(ID);
				}
				break;
			case STRING:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(180); match(STRING);
				}
				break;
			case NIL:
				_localctx = new NilAtomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(181); match(NIL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode TYPE_INT() { return getToken(VbParser.TYPE_INT, 0); }
		public TerminalNode TYPE_FLOAT() { return getToken(VbParser.TYPE_FLOAT, 0); }
		public TerminalNode TYPE_STRING() { return getToken(VbParser.TYPE_STRING, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof VbListener ) ((VbListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VbVisitor ) return ((VbVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INT) | (1L << TYPE_FLOAT) | (1L << TYPE_STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 10);

		case 1: return precpred(_ctx, 7);

		case 2: return precpred(_ctx, 6);

		case 3: return precpred(_ctx, 5);

		case 4: return precpred(_ctx, 4);

		case 5: return precpred(_ctx, 3);

		case 6: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\60\u00bd\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\3\7\3/\n\3\f\3\16\3\62\13"+
		"\3\3\3\7\3\65\n\3\f\3\16\38\13\3\5\3:\n\3\3\4\3\4\6\4>\n\4\r\4\16\4?\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\5\7Q\n\7\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t]\n\t\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7\rq\n\r\f\r\16"+
		"\rt\13\r\3\r\3\r\5\rx\n\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u0082\n\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u0094\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\7\23\u00ab\n\23\f\23\16\23\u00ae\13\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u00b9\n\24\3\25\3\25\3\25\2\3$\26\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(\2\n\4\2\6\6\b\b\3\2\27\31\3\2\25\26\3\2"+
		"\21\24\3\2\17\20\3\2+,\3\2#$\3\2\n\f\u00c3\2*\3\2\2\2\49\3\2\2\2\6;\3"+
		"\2\2\2\bD\3\2\2\2\nJ\3\2\2\2\fP\3\2\2\2\16R\3\2\2\2\20\\\3\2\2\2\22^\3"+
		"\2\2\2\24b\3\2\2\2\26g\3\2\2\2\30k\3\2\2\2\32y\3\2\2\2\34\u0081\3\2\2"+
		"\2\36\u0083\3\2\2\2 \u0087\3\2\2\2\"\u008a\3\2\2\2$\u0093\3\2\2\2&\u00b8"+
		"\3\2\2\2(\u00ba\3\2\2\2*+\5\4\3\2+,\7\2\2\3,\3\3\2\2\2-/\5\20\t\2.-\3"+
		"\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61:\3\2\2\2\62\60\3\2\2\2"+
		"\63\65\5\6\4\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67"+
		":\3\2\2\28\66\3\2\2\29\60\3\2\2\29\66\3\2\2\2:\5\3\2\2\2;=\5\b\5\2<>\5"+
		"\20\t\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\5\f\7\2BC"+
		"\5\16\b\2C\7\3\2\2\2DE\5\n\6\2EF\7\5\2\2FG\5\22\n\2GH\7\4\2\2HI\5(\25"+
		"\2I\t\3\2\2\2JK\t\2\2\2K\13\3\2\2\2LM\7\3\2\2MQ\5$\23\2NO\7\3\2\2OQ\7"+
		"*\2\2PL\3\2\2\2PN\3\2\2\2Q\r\3\2\2\2RS\7\7\2\2ST\7\5\2\2T\17\3\2\2\2U"+
		"]\5\26\f\2V]\5\24\13\2W]\5\30\r\2X]\5\36\20\2Y]\5\"\22\2Z[\7\60\2\2[]"+
		"\b\t\1\2\\U\3\2\2\2\\V\3\2\2\2\\W\3\2\2\2\\X\3\2\2\2\\Y\3\2\2\2\\Z\3\2"+
		"\2\2]\21\3\2\2\2^_\7*\2\2_`\7\36\2\2`a\7\37\2\2a\23\3\2\2\2bc\7\t\2\2"+
		"cd\7*\2\2de\7\4\2\2ef\5(\25\2f\25\3\2\2\2gh\7*\2\2hi\7\35\2\2ij\5$\23"+
		"\2j\27\3\2\2\2kl\7&\2\2lr\5\32\16\2mn\7\'\2\2no\7&\2\2oq\5\32\16\2pm\3"+
		"\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2sw\3\2\2\2tr\3\2\2\2uv\7\'\2\2vx\5"+
		"\34\17\2wu\3\2\2\2wx\3\2\2\2x\31\3\2\2\2yz\5$\23\2z{\5\34\17\2{\33\3\2"+
		"\2\2|}\7 \2\2}~\5\4\3\2~\177\7!\2\2\177\u0082\3\2\2\2\u0080\u0082\5\20"+
		"\t\2\u0081|\3\2\2\2\u0081\u0080\3\2\2\2\u0082\35\3\2\2\2\u0083\u0084\7"+
		"(\2\2\u0084\u0085\5$\23\2\u0085\u0086\5 \21\2\u0086\37\3\2\2\2\u0087\u0088"+
		"\5\4\3\2\u0088\u0089\7\"\2\2\u0089!\3\2\2\2\u008a\u008b\7)\2\2\u008b\u008c"+
		"\5$\23\2\u008c#\3\2\2\2\u008d\u008e\b\23\1\2\u008e\u008f\7\26\2\2\u008f"+
		"\u0094\5$\23\13\u0090\u0091\7\33\2\2\u0091\u0094\5$\23\n\u0092\u0094\5"+
		"&\24\2\u0093\u008d\3\2\2\2\u0093\u0090\3\2\2\2\u0093\u0092\3\2\2\2\u0094"+
		"\u00ac\3\2\2\2\u0095\u0096\f\f\2\2\u0096\u0097\7\32\2\2\u0097\u00ab\5"+
		"$\23\r\u0098\u0099\f\t\2\2\u0099\u009a\t\3\2\2\u009a\u00ab\5$\23\n\u009b"+
		"\u009c\f\b\2\2\u009c\u009d\t\4\2\2\u009d\u00ab\5$\23\t\u009e\u009f\f\7"+
		"\2\2\u009f\u00a0\t\5\2\2\u00a0\u00ab\5$\23\b\u00a1\u00a2\f\6\2\2\u00a2"+
		"\u00a3\t\6\2\2\u00a3\u00ab\5$\23\7\u00a4\u00a5\f\5\2\2\u00a5\u00a6\7\16"+
		"\2\2\u00a6\u00ab\5$\23\6\u00a7\u00a8\f\4\2\2\u00a8\u00a9\7\r\2\2\u00a9"+
		"\u00ab\5$\23\5\u00aa\u0095\3\2\2\2\u00aa\u0098\3\2\2\2\u00aa\u009b\3\2"+
		"\2\2\u00aa\u009e\3\2\2\2\u00aa\u00a1\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa"+
		"\u00a7\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad%\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\7\36\2\2\u00b0\u00b1"+
		"\5$\23\2\u00b1\u00b2\7\37\2\2\u00b2\u00b9\3\2\2\2\u00b3\u00b9\t\7\2\2"+
		"\u00b4\u00b9\t\b\2\2\u00b5\u00b9\7*\2\2\u00b6\u00b9\7-\2\2\u00b7\u00b9"+
		"\7%\2\2\u00b8\u00af\3\2\2\2\u00b8\u00b3\3\2\2\2\u00b8\u00b4\3\2\2\2\u00b8"+
		"\u00b5\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\'\3\2\2\2"+
		"\u00ba\u00bb\t\t\2\2\u00bb)\3\2\2\2\17\60\669?P\\rw\u0081\u0093\u00aa"+
		"\u00ac\u00b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}