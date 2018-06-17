// Generated from c:\Pedro\1 - isep\2 ano - 2 semestre\trabalhos\LAPR4\Projeto\repositorio_turma\shared\src\main\antlr4\pt\isep\nsheets\shared\core\formula\compiler\Formula.g4 by ANTLR 4.7.1

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
public class FormulaParser extends Parser {
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
		WS=38;
	public static final int
		RULE_expression = 0, RULE_comparison = 1, RULE_block = 2, RULE_forexpression = 3, 
		RULE_concatenation = 4, RULE_atom = 5, RULE_function_call = 6, RULE_reference = 7, 
		RULE_literal = 8, RULE_manyexpressions = 9, RULE_assignment = 10, RULE_temporaryreference = 11, 
		RULE_nameTemporary = 12;
	public static final String[] ruleNames = {
		"expression", "comparison", "block", "forexpression", "concatenation", 
		"atom", "function_call", "reference", "literal", "manyexpressions", "assignment", 
		"temporaryreference", "nameTemporary"
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
		"ICHA", "FCHA", "LBRACKET", "RBRACKET", "ASSIGN", "FOR", "WS"
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
	public String getGrammarFileName() { return "Formula.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FormulaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(FormulaParser.EQ, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(EQ);
			setState(27);
			comparison();
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
		public TerminalNode EQ() { return getToken(FormulaParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(FormulaParser.NEQ, 0); }
		public TerminalNode GT() { return getToken(FormulaParser.GT, 0); }
		public TerminalNode LT() { return getToken(FormulaParser.LT, 0); }
		public TerminalNode LTEQ() { return getToken(FormulaParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(FormulaParser.GTEQ, 0); }
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
			setState(29);
			concatenation(0);
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LTEQ) | (1L << GTEQ) | (1L << GT) | (1L << LT))) != 0)) {
				{
				setState(30);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LTEQ) | (1L << GTEQ) | (1L << GT) | (1L << LT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(31);
				concatenation(0);
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

	public static class BlockContext extends ParserRuleContext {
		public ManyexpressionsContext manyexpressions() {
			return getRuleContext(ManyexpressionsContext.class,0);
		}
		public TerminalNode FOR() { return getToken(FormulaParser.FOR, 0); }
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
		enterRule(_localctx, 4, RULE_block);
		try {
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ICHA:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				manyexpressions();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				match(FOR);
				setState(36);
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

	public static class ForexpressionContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public List<TerminalNode> SEMI() { return getTokens(FormulaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(FormulaParser.SEMI, i);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode FCHA() { return getToken(FormulaParser.FCHA, 0); }
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
		enterRule(_localctx, 6, RULE_forexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			assignment();
			setState(40);
			match(SEMI);
			setState(41);
			comparison();
			setState(44); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(42);
				match(SEMI);
				setState(43);
				concatenation(0);
				}
				}
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SEMI );
			setState(48);
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

	public static class ConcatenationContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(FormulaParser.MINUS, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ConcatenationContext> concatenation() {
			return getRuleContexts(ConcatenationContext.class);
		}
		public ConcatenationContext concatenation(int i) {
			return getRuleContext(ConcatenationContext.class,i);
		}
		public TerminalNode POWER() { return getToken(FormulaParser.POWER, 0); }
		public TerminalNode MULTI() { return getToken(FormulaParser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(FormulaParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(FormulaParser.PLUS, 0); }
		public TerminalNode AMP() { return getToken(FormulaParser.AMP, 0); }
		public TerminalNode PERCENT() { return getToken(FormulaParser.PERCENT, 0); }
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_concatenation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
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
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(51);
					match(MINUS);
					}
				}

				setState(54);
				atom();
				}
				break;
			case ICHA:
			case FOR:
				{
				setState(55);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(72);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(58);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(59);
						match(POWER);
						setState(60);
						concatenation(5);
						}
						break;
					case 2:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(61);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(62);
						_la = _input.LA(1);
						if ( !(_la==MULTI || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(63);
						concatenation(5);
						}
						break;
					case 3:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(64);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(65);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(66);
						concatenation(4);
						}
						break;
					case 4:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(67);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(68);
						match(AMP);
						setState(69);
						concatenation(3);
						}
						break;
					case 5:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(70);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(71);
						match(PERCENT);
						}
						break;
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		public TerminalNode LPAR() { return getToken(FormulaParser.LPAR, 0); }
		public ConcatenationContext concatenation() {
			return getRuleContext(ConcatenationContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FormulaParser.RPAR, 0); }
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
		enterRule(_localctx, 10, RULE_atom);
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				literal();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				match(LPAR);
				setState(82);
				concatenation(0);
				setState(83);
				match(RPAR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(85);
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

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(FormulaParser.FUNCTION, 0); }
		public TerminalNode LPAR() { return getToken(FormulaParser.LPAR, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FormulaParser.RPAR, 0); }
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(FUNCTION);
			setState(89);
			match(LPAR);
			setState(90);
			comparison();
			setState(91);
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
		public List<TerminalNode> CELL_REF() { return getTokens(FormulaParser.CELL_REF); }
		public TerminalNode CELL_REF(int i) {
			return getToken(FormulaParser.CELL_REF, i);
		}
		public TerminalNode COLON() { return getToken(FormulaParser.COLON, 0); }
		public TerminalNode NAMEGLOBAL() { return getToken(FormulaParser.NAMEGLOBAL, 0); }
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_reference);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CELL_REF:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(CELL_REF);
				setState(96);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					{
					setState(94);
					match(COLON);
					}
					setState(95);
					match(CELL_REF);
					}
					break;
				}
				}
				break;
			case NAMEGLOBAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(FormulaParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(FormulaParser.STRING, 0); }
		public NameTemporaryContext nameTemporary() {
			return getRuleContext(NameTemporaryContext.class,0);
		}
		public TerminalNode NAMEGLOBAL() { return getToken(FormulaParser.NAMEGLOBAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_literal);
		try {
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(NUMBER);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(STRING);
				}
				break;
			case UNDERSCORE:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				nameTemporary();
				}
				break;
			case NAMEGLOBAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
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

	public static class ManyexpressionsContext extends ParserRuleContext {
		public TerminalNode ICHA() { return getToken(FormulaParser.ICHA, 0); }
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public TerminalNode FCHA() { return getToken(FormulaParser.FCHA, 0); }
		public List<TerminalNode> SEMI() { return getTokens(FormulaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(FormulaParser.SEMI, i);
		}
		public ManyexpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_manyexpressions; }
	}

	public final ManyexpressionsContext manyexpressions() throws RecognitionException {
		ManyexpressionsContext _localctx = new ManyexpressionsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_manyexpressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(ICHA);
			setState(108);
			comparison();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMI) {
				{
				{
				setState(109);
				match(SEMI);
				setState(110);
				comparison();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
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

	public static class AssignmentContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(FormulaParser.ASSIGN, 0); }
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
			setState(118);
			reference();
			setState(119);
			match(ASSIGN);
			setState(120);
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

	public static class TemporaryreferenceContext extends ParserRuleContext {
		public NameTemporaryContext nameTemporary() {
			return getRuleContext(NameTemporaryContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(FormulaParser.ASSIGN, 0); }
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
		enterRule(_localctx, 22, RULE_temporaryreference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			nameTemporary();
			setState(123);
			match(ASSIGN);
			setState(124);
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
		public TerminalNode UNDERSCORE() { return getToken(FormulaParser.UNDERSCORE, 0); }
		public List<TerminalNode> LETTER() { return getTokens(FormulaParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(FormulaParser.LETTER, i);
		}
		public NameTemporaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameTemporary; }
	}

	public final NameTemporaryContext nameTemporary() throws RecognitionException {
		NameTemporaryContext _localctx = new NameTemporaryContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_nameTemporary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(UNDERSCORE);
			setState(128); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(127);
					match(LETTER);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(130); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		case 4:
			return concatenation_sempred((ConcatenationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean concatenation_sempred(ConcatenationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u0087\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\3\3\3\3\5\3#\n\3\3\4\3\4"+
		"\3\4\5\4(\n\4\3\5\3\5\3\5\3\5\3\5\6\5/\n\5\r\5\16\5\60\3\5\3\5\3\6\3\6"+
		"\5\6\67\n\6\3\6\3\6\5\6;\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\7\6K\n\6\f\6\16\6N\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7Y\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\5\tc\n\t\3\t\5\tf\n\t\3"+
		"\n\3\n\3\n\3\n\5\nl\n\n\3\13\3\13\3\13\3\13\7\13r\n\13\f\13\16\13u\13"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\6\16\u0083\n\16"+
		"\r\16\16\16\u0084\3\16\2\3\n\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\5\3"+
		"\2\r\22\3\2\26\27\3\2\24\25\2\u008f\2\34\3\2\2\2\4\37\3\2\2\2\6\'\3\2"+
		"\2\2\b)\3\2\2\2\n:\3\2\2\2\fX\3\2\2\2\16Z\3\2\2\2\20e\3\2\2\2\22k\3\2"+
		"\2\2\24m\3\2\2\2\26x\3\2\2\2\30|\3\2\2\2\32\u0080\3\2\2\2\34\35\7\r\2"+
		"\2\35\36\5\4\3\2\36\3\3\2\2\2\37\"\5\n\6\2 !\t\2\2\2!#\5\n\6\2\" \3\2"+
		"\2\2\"#\3\2\2\2#\5\3\2\2\2$(\5\24\13\2%&\7\'\2\2&(\5\b\5\2\'$\3\2\2\2"+
		"\'%\3\2\2\2(\7\3\2\2\2)*\5\26\f\2*+\7\37\2\2+.\5\4\3\2,-\7\37\2\2-/\5"+
		"\n\6\2.,\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62"+
		"\63\7#\2\2\63\t\3\2\2\2\64\66\b\6\1\2\65\67\7\25\2\2\66\65\3\2\2\2\66"+
		"\67\3\2\2\2\678\3\2\2\28;\5\f\7\29;\5\6\4\2:\64\3\2\2\2:9\3\2\2\2;L\3"+
		"\2\2\2<=\f\7\2\2=>\7\30\2\2>K\5\n\6\7?@\f\6\2\2@A\t\3\2\2AK\5\n\6\7BC"+
		"\f\5\2\2CD\t\4\2\2DK\5\n\6\6EF\f\4\2\2FG\7\23\2\2GK\5\n\6\5HI\f\b\2\2"+
		"IK\7\31\2\2J<\3\2\2\2J?\3\2\2\2JB\3\2\2\2JE\3\2\2\2JH\3\2\2\2KN\3\2\2"+
		"\2LJ\3\2\2\2LM\3\2\2\2M\13\3\2\2\2NL\3\2\2\2OY\5\16\b\2PY\5\20\t\2QY\5"+
		"\26\f\2RY\5\22\n\2ST\7 \2\2TU\5\n\6\2UV\7!\2\2VY\3\2\2\2WY\5\30\r\2XO"+
		"\3\2\2\2XP\3\2\2\2XQ\3\2\2\2XR\3\2\2\2XS\3\2\2\2XW\3\2\2\2Y\r\3\2\2\2"+
		"Z[\7\4\2\2[\\\7 \2\2\\]\5\4\3\2]^\7!\2\2^\17\3\2\2\2_b\7\5\2\2`a\7\32"+
		"\2\2ac\7\5\2\2b`\3\2\2\2bc\3\2\2\2cf\3\2\2\2df\7\6\2\2e_\3\2\2\2ed\3\2"+
		"\2\2f\21\3\2\2\2gl\7\t\2\2hl\7\7\2\2il\5\32\16\2jl\7\6\2\2kg\3\2\2\2k"+
		"h\3\2\2\2ki\3\2\2\2kj\3\2\2\2l\23\3\2\2\2mn\7\"\2\2ns\5\4\3\2op\7\37\2"+
		"\2pr\5\4\3\2qo\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2"+
		"\2vw\7#\2\2w\25\3\2\2\2xy\5\20\t\2yz\7&\2\2z{\5\n\6\2{\27\3\2\2\2|}\5"+
		"\32\16\2}~\7&\2\2~\177\5\n\6\2\177\31\3\2\2\2\u0080\u0082\7\33\2\2\u0081"+
		"\u0083\7\3\2\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0084\u0085\3\2\2\2\u0085\33\3\2\2\2\17\"\'\60\66:JLXbeks\u0084";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}