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
		LETTER=1, FUNCTION=2, CELL_REF=3, NAMEGLOBAL=4, STRING=5, QUOT=6, NUMBER=7, 
		FRACTIONALPART=8, DIGIT=9, DIGITNOTZERO=10, EQ=11, NEQ=12, LTEQ=13, GTEQ=14, 
		GT=15, LT=16, AMP=17, PLUS=18, MINUS=19, MULTI=20, DIV=21, POWER=22, PERCENT=23, 
		COLON=24, UNDERSCORE=25, ARROBA=26, COMMA=27, DOT=28, SEMI=29, LPAR=30, 
		RPAR=31, ICHA=32, FCHA=33, LBRACKET=34, RBRACKET=35, ASSIGN=36, FOR=37, 
		WS=38, COMMENT=39;
	public static final int
		RULE_expression = 0, RULE_comparison = 1, RULE_comment = 2, RULE_concatenation = 3, 
		RULE_atom = 4, RULE_block = 5, RULE_manyexpressions = 6, RULE_forexpression = 7, 
		RULE_function_call = 8, RULE_reference = 9, RULE_assignment = 10, RULE_literal = 11, 
		RULE_temporaryreference = 12, RULE_nameTemporary = 13;
	public static final String[] ruleNames = {
		"expression", "comparison", "comment", "concatenation", "atom", "block", 
		"manyexpressions", "forexpression", "function_call", "reference", "assignment", 
		"literal", "temporaryreference", "nameTemporary"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'\"'", null, null, null, null, "'='", 
		"'<>'", "'<='", "'>='", "'>'", "'<'", "'&'", "'+'", "'-'", "'*'", "'/'", 
		"'^'", "'%'", "':'", "'_'", "'@'", "','", "'.'", "';'", "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "':='", "'FOR{'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LETTER", "FUNCTION", "CELL_REF", "NAMEGLOBAL", "STRING", "QUOT", 
		"NUMBER", "FRACTIONALPART", "DIGIT", "DIGITNOTZERO", "EQ", "NEQ", "LTEQ", 
		"GTEQ", "GT", "LT", "AMP", "PLUS", "MINUS", "MULTI", "DIV", "POWER", "PERCENT", 
		"COLON", "UNDERSCORE", "ARROBA", "COMMA", "DOT", "SEMI", "LPAR", "RPAR", 
		"ICHA", "FCHA", "LBRACKET", "RBRACKET", "ASSIGN", "FOR", "WS", "COMMENT"
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
	public static class ExpressionContext extends ParserRuleContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
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
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
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
				setState(29);
				comparison();
				}
				break;
			case COMMENT:
				{
				setState(30);
				comment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(37);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(33);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(34);
						comparison();
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(35);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(36);
						comment();
						}
						break;
					}
					} 
				}
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
		enterRule(_localctx, 2, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			concatenation(0);
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(43);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LTEQ) | (1L << GTEQ) | (1L << GT) | (1L << LT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(44);
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
		enterRule(_localctx, 4, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_concatenation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
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
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(50);
					match(MINUS);
					}
				}

				setState(53);
				atom();
				}
				break;
			case ICHA:
			case FOR:
				{
				setState(54);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(73);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(71);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(57);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(58);
						match(POWER);
						setState(59);
						concatenation(5);
						}
						break;
					case 2:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(60);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(61);
						_la = _input.LA(1);
						if ( !(_la==MULTI || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(62);
						concatenation(5);
						}
						break;
					case 3:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(63);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(64);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(65);
						concatenation(4);
						}
						break;
					case 4:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(66);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(67);
						match(AMP);
						setState(68);
						concatenation(3);
						}
						break;
					case 5:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(69);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(70);
						match(PERCENT);
						}
						break;
					}
					} 
				}
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		enterRule(_localctx, 8, RULE_atom);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				literal();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				match(LPAR);
				setState(81);
				concatenation(0);
				setState(82);
				match(RPAR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(84);
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
		enterRule(_localctx, 10, RULE_block);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ICHA:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				manyexpressions();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(FOR);
				setState(89);
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
		enterRule(_localctx, 12, RULE_manyexpressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(ICHA);
			setState(93);
			comparison();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMI) {
				{
				{
				setState(94);
				match(SEMI);
				setState(95);
				comparison();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
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
		enterRule(_localctx, 14, RULE_forexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			assignment();
			setState(104);
			match(SEMI);
			setState(105);
			comparison();
			setState(108); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(106);
				match(SEMI);
				setState(107);
				concatenation(0);
				}
				}
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SEMI );
			setState(112);
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
		enterRule(_localctx, 16, RULE_function_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(FUNCTION);
			setState(115);
			match(LPAR);
			setState(116);
			comparison();
			setState(117);
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
		enterRule(_localctx, 18, RULE_reference);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CELL_REF:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(CELL_REF);
				setState(122);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					{
					setState(120);
					match(COLON);
					}
					setState(121);
					match(CELL_REF);
					}
					break;
				}
				}
				break;
			case NAMEGLOBAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
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
		enterRule(_localctx, 20, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			reference();
			setState(128);
			match(ASSIGN);
			setState(129);
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
		enterRule(_localctx, 22, RULE_literal);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(NUMBER);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				match(STRING);
				}
				break;
			case UNDERSCORE:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				nameTemporary();
				}
				break;
			case NAMEGLOBAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
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
		enterRule(_localctx, 24, RULE_temporaryreference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			nameTemporary();
			setState(138);
			match(ASSIGN);
			setState(139);
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
		enterRule(_localctx, 26, RULE_nameTemporary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(UNDERSCORE);
			setState(143); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(142);
					match(LETTER);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(145); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		case 0:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 3:
			return concatenation_sempred((ConcatenationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean concatenation_sempred(ConcatenationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u0096\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\5\2\"\n\2\3\2\3\2"+
		"\3\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\3\3\3\3\3\5\3\60\n\3\3\4\3\4\3\5\3"+
		"\5\5\5\66\n\5\3\5\3\5\5\5:\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\7\5J\n\5\f\5\16\5M\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6X\n\6\3\7\3\7\3\7\5\7]\n\7\3\b\3\b\3\b\3\b\7\bc\n\b\f\b\16\b"+
		"f\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\6\to\n\t\r\t\16\tp\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\5\13}\n\13\3\13\5\13\u0080\n\13\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\5\r\u008a\n\r\3\16\3\16\3\16\3\16\3\17\3\17\6\17"+
		"\u0092\n\17\r\17\16\17\u0093\3\17\2\4\2\b\20\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\2\5\3\2\r\22\3\2\26\27\3\2\24\25\2\u00a0\2!\3\2\2\2\4,\3\2\2"+
		"\2\6\61\3\2\2\2\b9\3\2\2\2\nW\3\2\2\2\f\\\3\2\2\2\16^\3\2\2\2\20i\3\2"+
		"\2\2\22t\3\2\2\2\24\177\3\2\2\2\26\u0081\3\2\2\2\30\u0089\3\2\2\2\32\u008b"+
		"\3\2\2\2\34\u008f\3\2\2\2\36\37\b\2\1\2\37\"\5\4\3\2 \"\5\6\4\2!\36\3"+
		"\2\2\2! \3\2\2\2\")\3\2\2\2#$\f\6\2\2$(\5\4\3\2%&\f\5\2\2&(\5\6\4\2\'"+
		"#\3\2\2\2\'%\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\3\3\2\2\2+)\3\2\2"+
		"\2,/\5\b\5\2-.\t\2\2\2.\60\5\b\5\2/-\3\2\2\2/\60\3\2\2\2\60\5\3\2\2\2"+
		"\61\62\7)\2\2\62\7\3\2\2\2\63\65\b\5\1\2\64\66\7\25\2\2\65\64\3\2\2\2"+
		"\65\66\3\2\2\2\66\67\3\2\2\2\67:\5\n\6\28:\5\f\7\29\63\3\2\2\298\3\2\2"+
		"\2:K\3\2\2\2;<\f\7\2\2<=\7\30\2\2=J\5\b\5\7>?\f\6\2\2?@\t\3\2\2@J\5\b"+
		"\5\7AB\f\5\2\2BC\t\4\2\2CJ\5\b\5\6DE\f\4\2\2EF\7\23\2\2FJ\5\b\5\5GH\f"+
		"\b\2\2HJ\7\31\2\2I;\3\2\2\2I>\3\2\2\2IA\3\2\2\2ID\3\2\2\2IG\3\2\2\2JM"+
		"\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\t\3\2\2\2MK\3\2\2\2NX\5\22\n\2OX\5\24\13"+
		"\2PX\5\26\f\2QX\5\30\r\2RS\7 \2\2ST\5\b\5\2TU\7!\2\2UX\3\2\2\2VX\5\32"+
		"\16\2WN\3\2\2\2WO\3\2\2\2WP\3\2\2\2WQ\3\2\2\2WR\3\2\2\2WV\3\2\2\2X\13"+
		"\3\2\2\2Y]\5\16\b\2Z[\7\'\2\2[]\5\20\t\2\\Y\3\2\2\2\\Z\3\2\2\2]\r\3\2"+
		"\2\2^_\7\"\2\2_d\5\4\3\2`a\7\37\2\2ac\5\4\3\2b`\3\2\2\2cf\3\2\2\2db\3"+
		"\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7#\2\2h\17\3\2\2\2ij\5\26\f\2j"+
		"k\7\37\2\2kn\5\4\3\2lm\7\37\2\2mo\5\b\5\2nl\3\2\2\2op\3\2\2\2pn\3\2\2"+
		"\2pq\3\2\2\2qr\3\2\2\2rs\7#\2\2s\21\3\2\2\2tu\7\4\2\2uv\7 \2\2vw\5\4\3"+
		"\2wx\7!\2\2x\23\3\2\2\2y|\7\5\2\2z{\7\32\2\2{}\7\5\2\2|z\3\2\2\2|}\3\2"+
		"\2\2}\u0080\3\2\2\2~\u0080\7\6\2\2\177y\3\2\2\2\177~\3\2\2\2\u0080\25"+
		"\3\2\2\2\u0081\u0082\5\24\13\2\u0082\u0083\7&\2\2\u0083\u0084\5\b\5\2"+
		"\u0084\27\3\2\2\2\u0085\u008a\7\t\2\2\u0086\u008a\7\7\2\2\u0087\u008a"+
		"\5\34\17\2\u0088\u008a\7\6\2\2\u0089\u0085\3\2\2\2\u0089\u0086\3\2\2\2"+
		"\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a\31\3\2\2\2\u008b\u008c"+
		"\5\34\17\2\u008c\u008d\7&\2\2\u008d\u008e\5\b\5\2\u008e\33\3\2\2\2\u008f"+
		"\u0091\7\33\2\2\u0090\u0092\7\3\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3"+
		"\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\35\3\2\2\2\22!\'"+
		")/\659IKW\\dp|\177\u0089\u0093";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}