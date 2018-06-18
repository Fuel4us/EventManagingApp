// Generated from c:\Pedro\1 - isep\2 ano - 2 semestre\trabalhos\LAPR4\Projeto\repositorio_turma\shared\src\main\antlr4\pt\isep\nsheets\shared\core\formula\compiler\Macro.g4 by ANTLR 4.7.1

	//package pt.isep.nsheets.shared.core.formula.compiler;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MacroParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, FUNCTION=4, LETTER=5, CELL_REF=6, NAMEGLOBAL=7, 
		STRING=8, QUOT=9, NUMBER=10, FRACTIONALPART=11, DIGIT=12, DIGITNOTZERO=13, 
		EQ=14, NEQ=15, LTEQ=16, GTEQ=17, GT=18, LT=19, AMP=20, PLUS=21, MINUS=22, 
		MULTI=23, DIV=24, POWER=25, PERCENT=26, COLON=27, UNDERSCORE=28, ARROBA=29, 
		COMMA=30, DOT=31, SEMI=32, LPAR=33, RPAR=34, ICHA=35, FCHA=36, LBRACKET=37, 
		RBRACKET=38, ASSIGN=39, FOR=40, WS=41, COMMENT=42;
	public static final int
		RULE_stat = 0, RULE_expression = 1, RULE_functionimpl = 2, RULE_functionimplbody = 3, 
		RULE_functionimplreturn = 4, RULE_comparison = 5, RULE_comment = 6, RULE_functioncall = 7, 
		RULE_concatenation = 8, RULE_atom = 9, RULE_block = 10, RULE_manyexpressions = 11, 
		RULE_forexpression = 12, RULE_function_call = 13, RULE_reference = 14, 
		RULE_assignment = 15, RULE_literal = 16, RULE_temporaryreference = 17, 
		RULE_nameTemporary = 18;
	public static final String[] ruleNames = {
		"stat", "expression", "functionimpl", "functionimplbody", "functionimplreturn", 
		"comparison", "comment", "functioncall", "concatenation", "atom", "block", 
		"manyexpressions", "forexpression", "function_call", "reference", "assignment", 
		"literal", "temporaryreference", "nameTemporary"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Macro'", "'return'", "'Call'", null, null, null, null, null, "'\"'", 
		null, null, null, null, "'='", "'<>'", "'<='", "'>='", "'>'", "'<'", "'&'", 
		"'+'", "'-'", "'*'", "'/'", "'^'", "'%'", "':'", "'_'", "'@'", "','", 
		"'.'", "';'", "'('", "')'", "'{'", "'}'", "'['", "']'", "':='", "'FOR{'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "FUNCTION", "LETTER", "CELL_REF", "NAMEGLOBAL", 
		"STRING", "QUOT", "NUMBER", "FRACTIONALPART", "DIGIT", "DIGITNOTZERO", 
		"EQ", "NEQ", "LTEQ", "GTEQ", "GT", "LT", "AMP", "PLUS", "MINUS", "MULTI", 
		"DIV", "POWER", "PERCENT", "COLON", "UNDERSCORE", "ARROBA", "COMMA", "DOT", 
		"SEMI", "LPAR", "RPAR", "ICHA", "FCHA", "LBRACKET", "RBRACKET", "ASSIGN", 
		"FOR", "WS", "COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Macro.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MacroParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StatContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionimplContext functionimpl() {
			return getRuleContext(FunctionimplContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stat);
		try {
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case FUNCTION:
			case CELL_REF:
			case NAMEGLOBAL:
			case STRING:
			case NUMBER:
			case MINUS:
			case UNDERSCORE:
			case LPAR:
			case ICHA:
			case FOR:
			case COMMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				expression(0);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				functionimpl(0);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCTION:
			case CELL_REF:
			case NAMEGLOBAL:
			case STRING:
			case NUMBER:
			case MINUS:
			case UNDERSCORE:
			case LPAR:
			case ICHA:
			case FOR:
				{
				setState(43);
				comparison();
				}
				break;
			case COMMENT:
				{
				setState(44);
				comment();
				}
				break;
			case T__2:
				{
				setState(45);
				functioncall();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(56);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(54);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(48);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(49);
						comparison();
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(50);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(51);
						comment();
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(52);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(53);
						functioncall();
						}
						break;
					}
					} 
				}
				setState(58);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class FunctionimplContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(MacroParser.FUNCTION, 0); }
		public TerminalNode ICHA() { return getToken(MacroParser.ICHA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FCHA() { return getToken(MacroParser.FCHA, 0); }
		public FunctionimplContext functionimpl() {
			return getRuleContext(FunctionimplContext.class,0);
		}
		public FunctionimplContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionimpl; }
	}

	public final FunctionimplContext functionimpl() throws RecognitionException {
		return functionimpl(0);
	}

	private FunctionimplContext functionimpl(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FunctionimplContext _localctx = new FunctionimplContext(_ctx, _parentState);
		FunctionimplContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_functionimpl, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(60);
			match(T__0);
			setState(61);
			match(FUNCTION);
			setState(62);
			match(ICHA);
			setState(63);
			expression(0);
			setState(64);
			match(FCHA);
			}
			_ctx.stop = _input.LT(-1);
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FunctionimplContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_functionimpl);
					setState(66);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(67);
					match(T__0);
					setState(68);
					match(FUNCTION);
					setState(69);
					match(ICHA);
					setState(70);
					expression(0);
					setState(71);
					match(FCHA);
					}
					} 
				}
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class FunctionimplbodyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionimplreturnContext functionimplreturn() {
			return getRuleContext(FunctionimplreturnContext.class,0);
		}
		public FunctionimplbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionimplbody; }
	}

	public final FunctionimplbodyContext functionimplbody() throws RecognitionException {
		FunctionimplbodyContext _localctx = new FunctionimplbodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionimplbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			expression(0);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(79);
				functionimplreturn();
				}
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

	public static class FunctionimplreturnContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ConcatenationContext concatenation() {
			return getRuleContext(ConcatenationContext.class,0);
		}
		public FunctionimplreturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionimplreturn; }
	}

	public final FunctionimplreturnContext functionimplreturn() throws RecognitionException {
		FunctionimplreturnContext _localctx = new FunctionimplreturnContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionimplreturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__1);
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(83);
				assignment();
				}
				break;
			case 2:
				{
				setState(84);
				concatenation(0);
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

	public static class ComparisonContext extends ParserRuleContext {
		public List<ConcatenationContext> concatenation() {
			return getRuleContexts(ConcatenationContext.class);
		}
		public ConcatenationContext concatenation(int i) {
			return getRuleContext(ConcatenationContext.class,i);
		}
		public TerminalNode EQ() { return getToken(MacroParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MacroParser.NEQ, 0); }
		public TerminalNode GT() { return getToken(MacroParser.GT, 0); }
		public TerminalNode LT() { return getToken(MacroParser.LT, 0); }
		public TerminalNode LTEQ() { return getToken(MacroParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(MacroParser.GTEQ, 0); }
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			concatenation(0);
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(88);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LTEQ) | (1L << GTEQ) | (1L << GT) | (1L << LT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(89);
				concatenation(0);
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

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(MacroParser.COMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(COMMENT);
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

	public static class FunctioncallContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(MacroParser.FUNCTION, 0); }
		public FunctioncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioncall; }
	}

	public final FunctioncallContext functioncall() throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functioncall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__2);
			setState(95);
			match(FUNCTION);
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

	public static class ConcatenationContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(MacroParser.MINUS, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ConcatenationContext> concatenation() {
			return getRuleContexts(ConcatenationContext.class);
		}
		public ConcatenationContext concatenation(int i) {
			return getRuleContext(ConcatenationContext.class,i);
		}
		public TerminalNode POWER() { return getToken(MacroParser.POWER, 0); }
		public TerminalNode MULTI() { return getToken(MacroParser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(MacroParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(MacroParser.PLUS, 0); }
		public TerminalNode AMP() { return getToken(MacroParser.AMP, 0); }
		public TerminalNode PERCENT() { return getToken(MacroParser.PERCENT, 0); }
		public ConcatenationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatenation; }
	}

	public final ConcatenationContext concatenation() throws RecognitionException {
		return concatenation(0);
	}

	private ConcatenationContext concatenation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConcatenationContext _localctx = new ConcatenationContext(_ctx, _parentState);
		ConcatenationContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_concatenation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCTION:
			case CELL_REF:
			case NAMEGLOBAL:
			case STRING:
			case NUMBER:
			case MINUS:
			case UNDERSCORE:
			case LPAR:
				{
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(98);
					match(MINUS);
					}
				}

				setState(101);
				atom();
				}
				break;
			case ICHA:
			case FOR:
				{
				setState(102);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(119);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(105);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(106);
						match(POWER);
						setState(107);
						concatenation(5);
						}
						break;
					case 2:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(108);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(109);
						_la = _input.LA(1);
						if ( !(_la==MULTI || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(110);
						concatenation(5);
						}
						break;
					case 3:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(111);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(112);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(113);
						concatenation(4);
						}
						break;
					case 4:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(114);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(115);
						match(AMP);
						setState(116);
						concatenation(3);
						}
						break;
					case 5:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(117);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(118);
						match(PERCENT);
						}
						break;
					}
					} 
				}
				setState(123);
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
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(MacroParser.LPAR, 0); }
		public ConcatenationContext concatenation() {
			return getRuleContext(ConcatenationContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(MacroParser.RPAR, 0); }
		public TemporaryreferenceContext temporaryreference() {
			return getRuleContext(TemporaryreferenceContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atom);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(127);
				literal();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
				match(LPAR);
				setState(129);
				concatenation(0);
				setState(130);
				match(RPAR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(132);
				temporaryreference();
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

	public static class BlockContext extends ParserRuleContext {
		public ManyexpressionsContext manyexpressions() {
			return getRuleContext(ManyexpressionsContext.class,0);
		}
		public TerminalNode FOR() { return getToken(MacroParser.FOR, 0); }
		public ForexpressionContext forexpression() {
			return getRuleContext(ForexpressionContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block);
		try {
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ICHA:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				manyexpressions();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				match(FOR);
				setState(137);
				forexpression();
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

	public static class ManyexpressionsContext extends ParserRuleContext {
		public TerminalNode ICHA() { return getToken(MacroParser.ICHA, 0); }
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public TerminalNode FCHA() { return getToken(MacroParser.FCHA, 0); }
		public List<TerminalNode> SEMI() { return getTokens(MacroParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MacroParser.SEMI, i);
		}
		public ManyexpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_manyexpressions; }
	}

	public final ManyexpressionsContext manyexpressions() throws RecognitionException {
		ManyexpressionsContext _localctx = new ManyexpressionsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_manyexpressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(ICHA);
			setState(141);
			comparison();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMI) {
				{
				{
				setState(142);
				match(SEMI);
				setState(143);
				comparison();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(149);
			match(FCHA);
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

	public static class ForexpressionContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public List<TerminalNode> SEMI() { return getTokens(MacroParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MacroParser.SEMI, i);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode FCHA() { return getToken(MacroParser.FCHA, 0); }
		public List<ConcatenationContext> concatenation() {
			return getRuleContexts(ConcatenationContext.class);
		}
		public ConcatenationContext concatenation(int i) {
			return getRuleContext(ConcatenationContext.class,i);
		}
		public ForexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forexpression; }
	}

	public final ForexpressionContext forexpression() throws RecognitionException {
		ForexpressionContext _localctx = new ForexpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			assignment();
			setState(152);
			match(SEMI);
			setState(153);
			comparison();
			setState(156); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(154);
				match(SEMI);
				setState(155);
				concatenation(0);
				}
				}
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SEMI );
			setState(160);
			match(FCHA);
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

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(MacroParser.FUNCTION, 0); }
		public TerminalNode LPAR() { return getToken(MacroParser.LPAR, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(MacroParser.RPAR, 0); }
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(FUNCTION);
			setState(163);
			match(LPAR);
			setState(164);
			comparison();
			setState(165);
			match(RPAR);
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

	public static class ReferenceContext extends ParserRuleContext {
		public List<TerminalNode> CELL_REF() { return getTokens(MacroParser.CELL_REF); }
		public TerminalNode CELL_REF(int i) {
			return getToken(MacroParser.CELL_REF, i);
		}
		public TerminalNode COLON() { return getToken(MacroParser.COLON, 0); }
		public TerminalNode NAMEGLOBAL() { return getToken(MacroParser.NAMEGLOBAL, 0); }
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_reference);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CELL_REF:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(CELL_REF);
				setState(170);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					{
					setState(168);
					match(COLON);
					}
					setState(169);
					match(CELL_REF);
					}
					break;
				}
				}
				break;
			case NAMEGLOBAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(NAMEGLOBAL);
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

	public static class AssignmentContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MacroParser.ASSIGN, 0); }
		public ConcatenationContext concatenation() {
			return getRuleContext(ConcatenationContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			reference();
			setState(176);
			match(ASSIGN);
			setState(177);
			concatenation(0);
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(MacroParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(MacroParser.STRING, 0); }
		public NameTemporaryContext nameTemporary() {
			return getRuleContext(NameTemporaryContext.class,0);
		}
		public TerminalNode NAMEGLOBAL() { return getToken(MacroParser.NAMEGLOBAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_literal);
		try {
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(NUMBER);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(STRING);
				}
				break;
			case UNDERSCORE:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				nameTemporary();
				}
				break;
			case NAMEGLOBAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(182);
				match(NAMEGLOBAL);
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

	public static class TemporaryreferenceContext extends ParserRuleContext {
		public NameTemporaryContext nameTemporary() {
			return getRuleContext(NameTemporaryContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MacroParser.ASSIGN, 0); }
		public ConcatenationContext concatenation() {
			return getRuleContext(ConcatenationContext.class,0);
		}
		public TemporaryreferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporaryreference; }
	}

	public final TemporaryreferenceContext temporaryreference() throws RecognitionException {
		TemporaryreferenceContext _localctx = new TemporaryreferenceContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_temporaryreference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			nameTemporary();
			setState(186);
			match(ASSIGN);
			setState(187);
			concatenation(0);
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

	public static class NameTemporaryContext extends ParserRuleContext {
		public TerminalNode UNDERSCORE() { return getToken(MacroParser.UNDERSCORE, 0); }
		public List<TerminalNode> LETTER() { return getTokens(MacroParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(MacroParser.LETTER, i);
		}
		public NameTemporaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameTemporary; }
	}

	public final NameTemporaryContext nameTemporary() throws RecognitionException {
		NameTemporaryContext _localctx = new NameTemporaryContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_nameTemporary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(UNDERSCORE);
			setState(191); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(190);
					match(LETTER);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(193); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		case 1:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 2:
			return functionimpl_sempred((FunctionimplContext)_localctx, predIndex);
		case 8:
			return concatenation_sempred((ConcatenationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean functionimpl_sempred(FunctionimplContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean concatenation_sempred(ConcatenationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u00c6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\5\2+\n\2\3\3\3\3\3\3\3\3\5\3\61\n\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\7\39\n\3\f\3\16\3<\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3\5\3\5\5\5S\n\5"+
		"\3\6\3\6\3\6\5\6X\n\6\3\7\3\7\3\7\5\7]\n\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n"+
		"\5\nf\n\n\3\n\3\n\5\nj\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\7\nz\n\n\f\n\16\n}\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u0088\n\13\3\f\3\f\3\f\5\f\u008d\n\f\3\r\3\r\3\r\3\r\7"+
		"\r\u0093\n\r\f\r\16\r\u0096\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\6\16"+
		"\u009f\n\16\r\16\16\16\u00a0\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\5\20\u00ad\n\20\3\20\5\20\u00b0\n\20\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\5\22\u00ba\n\22\3\23\3\23\3\23\3\23\3\24\3\24\6\24\u00c2"+
		"\n\24\r\24\16\24\u00c3\3\24\2\5\4\6\22\25\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&\2\5\3\2\20\25\3\2\31\32\3\2\27\30\2\u00d1\2*\3\2\2\2\4"+
		"\60\3\2\2\2\6=\3\2\2\2\bP\3\2\2\2\nT\3\2\2\2\fY\3\2\2\2\16^\3\2\2\2\20"+
		"`\3\2\2\2\22i\3\2\2\2\24\u0087\3\2\2\2\26\u008c\3\2\2\2\30\u008e\3\2\2"+
		"\2\32\u0099\3\2\2\2\34\u00a4\3\2\2\2\36\u00af\3\2\2\2 \u00b1\3\2\2\2\""+
		"\u00b9\3\2\2\2$\u00bb\3\2\2\2&\u00bf\3\2\2\2(+\5\4\3\2)+\5\6\4\2*(\3\2"+
		"\2\2*)\3\2\2\2+\3\3\2\2\2,-\b\3\1\2-\61\5\f\7\2.\61\5\16\b\2/\61\5\20"+
		"\t\2\60,\3\2\2\2\60.\3\2\2\2\60/\3\2\2\2\61:\3\2\2\2\62\63\f\b\2\2\63"+
		"9\5\f\7\2\64\65\f\7\2\2\659\5\16\b\2\66\67\f\6\2\2\679\5\20\t\28\62\3"+
		"\2\2\28\64\3\2\2\28\66\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\5\3\2\2"+
		"\2<:\3\2\2\2=>\b\4\1\2>?\7\3\2\2?@\7\6\2\2@A\7%\2\2AB\5\4\3\2BC\7&\2\2"+
		"CM\3\2\2\2DE\f\4\2\2EF\7\3\2\2FG\7\6\2\2GH\7%\2\2HI\5\4\3\2IJ\7&\2\2J"+
		"L\3\2\2\2KD\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\7\3\2\2\2OM\3\2\2\2"+
		"PR\5\4\3\2QS\5\n\6\2RQ\3\2\2\2RS\3\2\2\2S\t\3\2\2\2TW\7\4\2\2UX\5 \21"+
		"\2VX\5\22\n\2WU\3\2\2\2WV\3\2\2\2X\13\3\2\2\2Y\\\5\22\n\2Z[\t\2\2\2[]"+
		"\5\22\n\2\\Z\3\2\2\2\\]\3\2\2\2]\r\3\2\2\2^_\7,\2\2_\17\3\2\2\2`a\7\5"+
		"\2\2ab\7\6\2\2b\21\3\2\2\2ce\b\n\1\2df\7\30\2\2ed\3\2\2\2ef\3\2\2\2fg"+
		"\3\2\2\2gj\5\24\13\2hj\5\26\f\2ic\3\2\2\2ih\3\2\2\2j{\3\2\2\2kl\f\7\2"+
		"\2lm\7\33\2\2mz\5\22\n\7no\f\6\2\2op\t\3\2\2pz\5\22\n\7qr\f\5\2\2rs\t"+
		"\4\2\2sz\5\22\n\6tu\f\4\2\2uv\7\26\2\2vz\5\22\n\5wx\f\b\2\2xz\7\34\2\2"+
		"yk\3\2\2\2yn\3\2\2\2yq\3\2\2\2yt\3\2\2\2yw\3\2\2\2z}\3\2\2\2{y\3\2\2\2"+
		"{|\3\2\2\2|\23\3\2\2\2}{\3\2\2\2~\u0088\5\34\17\2\177\u0088\5\36\20\2"+
		"\u0080\u0088\5 \21\2\u0081\u0088\5\"\22\2\u0082\u0083\7#\2\2\u0083\u0084"+
		"\5\22\n\2\u0084\u0085\7$\2\2\u0085\u0088\3\2\2\2\u0086\u0088\5$\23\2\u0087"+
		"~\3\2\2\2\u0087\177\3\2\2\2\u0087\u0080\3\2\2\2\u0087\u0081\3\2\2\2\u0087"+
		"\u0082\3\2\2\2\u0087\u0086\3\2\2\2\u0088\25\3\2\2\2\u0089\u008d\5\30\r"+
		"\2\u008a\u008b\7*\2\2\u008b\u008d\5\32\16\2\u008c\u0089\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008d\27\3\2\2\2\u008e\u008f\7%\2\2\u008f\u0094\5\f\7\2"+
		"\u0090\u0091\7\"\2\2\u0091\u0093\5\f\7\2\u0092\u0090\3\2\2\2\u0093\u0096"+
		"\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0097\u0098\7&\2\2\u0098\31\3\2\2\2\u0099\u009a\5 \21\2"+
		"\u009a\u009b\7\"\2\2\u009b\u009e\5\f\7\2\u009c\u009d\7\"\2\2\u009d\u009f"+
		"\5\22\n\2\u009e\u009c\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2"+
		"\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7&\2\2\u00a3\33\3"+
		"\2\2\2\u00a4\u00a5\7\6\2\2\u00a5\u00a6\7#\2\2\u00a6\u00a7\5\f\7\2\u00a7"+
		"\u00a8\7$\2\2\u00a8\35\3\2\2\2\u00a9\u00ac\7\b\2\2\u00aa\u00ab\7\35\2"+
		"\2\u00ab\u00ad\7\b\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b0"+
		"\3\2\2\2\u00ae\u00b0\7\t\2\2\u00af\u00a9\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0"+
		"\37\3\2\2\2\u00b1\u00b2\5\36\20\2\u00b2\u00b3\7)\2\2\u00b3\u00b4\5\22"+
		"\n\2\u00b4!\3\2\2\2\u00b5\u00ba\7\f\2\2\u00b6\u00ba\7\n\2\2\u00b7\u00ba"+
		"\5&\24\2\u00b8\u00ba\7\t\2\2\u00b9\u00b5\3\2\2\2\u00b9\u00b6\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba#\3\2\2\2\u00bb\u00bc\5&\24\2"+
		"\u00bc\u00bd\7)\2\2\u00bd\u00be\5\22\n\2\u00be%\3\2\2\2\u00bf\u00c1\7"+
		"\36\2\2\u00c0\u00c2\7\7\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\'\3\2\2\2\26*\608:MRW\\eiy{\u0087"+
		"\u008c\u0094\u00a0\u00ac\u00af\u00b9\u00c3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}