// Generated from c:\Pedro\1 - isep\2 ano - 2 semestre\trabalhos\LAPR4\Projeto\repositorio_turma\shared\src\main\antlr4\pt\isep\nsheets\shared\core\formula\compiler\Formula.g4 by ANTLR 4.7.1

	//package pt.isep.nsheets.shared.core.formula.compiler;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormulaLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "FUNCTION", "CELL_REF", "NAMEGLOBAL", "STRING", "QUOT", "NUMBER", 
		"FRACTIONALPART", "DIGIT", "DIGITNOTZERO", "EQ", "NEQ", "LTEQ", "GTEQ", 
		"GT", "LT", "AMP", "PLUS", "MINUS", "MULTI", "DIV", "POWER", "PERCENT", 
		"ABS", "EXCL", "COLON", "UNDERSCORE", "ARROBA", "COMMA", "DOT", "SEMI", 
		"LPAR", "RPAR", "ICHA", "FCHA", "LBRACKET", "RBRACKET", "ASSIGN", "FOR", 
		"WS"
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


	public FormulaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Formula.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u00e3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\3\6"+
		"\3W\n\3\r\3\16\3X\3\4\5\4\\\n\4\3\4\3\4\5\4`\n\4\3\4\5\4c\n\4\3\4\6\4"+
		"f\n\4\r\4\16\4g\3\5\3\5\6\5l\n\5\r\5\16\5m\3\6\3\6\3\6\3\6\7\6t\n\6\f"+
		"\6\16\6w\13\6\3\6\3\6\3\7\3\7\3\b\3\b\7\b\177\n\b\f\b\16\b\u0082\13\b"+
		"\3\b\5\b\u0085\n\b\3\b\3\b\3\b\5\b\u008a\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\t\u0093\n\t\5\t\u0095\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3"+
		"#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\5)\u00e0"+
		"\n)\3)\3)\2\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\2\63\2\65\32\67"+
		"\339\34;\35=\36?\37A C!E\"G#I$K%M&O\'Q(\3\2\4\4\2C\\c|\3\2$$\2\u00ef\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5V\3\2\2\2\7[\3\2\2\2\ti\3\2"+
		"\2\2\13o\3\2\2\2\rz\3\2\2\2\17\u0089\3\2\2\2\21\u0094\3\2\2\2\23\u0096"+
		"\3\2\2\2\25\u0098\3\2\2\2\27\u009a\3\2\2\2\31\u009c\3\2\2\2\33\u009f\3"+
		"\2\2\2\35\u00a2\3\2\2\2\37\u00a5\3\2\2\2!\u00a7\3\2\2\2#\u00a9\3\2\2\2"+
		"%\u00ab\3\2\2\2\'\u00ad\3\2\2\2)\u00af\3\2\2\2+\u00b1\3\2\2\2-\u00b3\3"+
		"\2\2\2/\u00b5\3\2\2\2\61\u00b7\3\2\2\2\63\u00b9\3\2\2\2\65\u00bb\3\2\2"+
		"\2\67\u00bd\3\2\2\29\u00bf\3\2\2\2;\u00c1\3\2\2\2=\u00c3\3\2\2\2?\u00c5"+
		"\3\2\2\2A\u00c7\3\2\2\2C\u00c9\3\2\2\2E\u00cb\3\2\2\2G\u00cd\3\2\2\2I"+
		"\u00cf\3\2\2\2K\u00d1\3\2\2\2M\u00d3\3\2\2\2O\u00d6\3\2\2\2Q\u00df\3\2"+
		"\2\2ST\t\2\2\2T\4\3\2\2\2UW\5\3\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3"+
		"\2\2\2Y\6\3\2\2\2Z\\\5\61\31\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]_\5\3\2"+
		"\2^`\5\3\2\2_^\3\2\2\2_`\3\2\2\2`b\3\2\2\2ac\5\61\31\2ba\3\2\2\2bc\3\2"+
		"\2\2ce\3\2\2\2df\5\23\n\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\b\3"+
		"\2\2\2ik\59\35\2jl\5\3\2\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\n"+
		"\3\2\2\2ou\5\r\7\2pq\7^\2\2qt\7$\2\2rt\n\3\2\2sp\3\2\2\2sr\3\2\2\2tw\3"+
		"\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2xy\5\r\7\2y\f\3\2\2\2z{"+
		"\7$\2\2{\16\3\2\2\2|\u0080\5\25\13\2}\177\5\23\n\2~}\3\2\2\2\177\u0082"+
		"\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0084\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0083\u0085\5\21\t\2\u0084\u0083\3\2\2\2\u0084\u0085\3"+
		"\2\2\2\u0085\u008a\3\2\2\2\u0086\u0087\5\23\n\2\u0087\u0088\5\21\t\2\u0088"+
		"\u008a\3\2\2\2\u0089|\3\2\2\2\u0089\u0086\3\2\2\2\u008a\20\3\2\2\2\u008b"+
		"\u008c\5;\36\2\u008c\u008d\5\23\n\2\u008d\u008e\5\23\n\2\u008e\u0095\3"+
		"\2\2\2\u008f\u0090\5=\37\2\u0090\u0092\5\23\n\2\u0091\u0093\5\23\n\2\u0092"+
		"\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u008b\3\2"+
		"\2\2\u0094\u008f\3\2\2\2\u0095\22\3\2\2\2\u0096\u0097\4\62;\2\u0097\24"+
		"\3\2\2\2\u0098\u0099\4\63;\2\u0099\26\3\2\2\2\u009a\u009b\7?\2\2\u009b"+
		"\30\3\2\2\2\u009c\u009d\7>\2\2\u009d\u009e\7@\2\2\u009e\32\3\2\2\2\u009f"+
		"\u00a0\7>\2\2\u00a0\u00a1\7?\2\2\u00a1\34\3\2\2\2\u00a2\u00a3\7@\2\2\u00a3"+
		"\u00a4\7?\2\2\u00a4\36\3\2\2\2\u00a5\u00a6\7@\2\2\u00a6 \3\2\2\2\u00a7"+
		"\u00a8\7>\2\2\u00a8\"\3\2\2\2\u00a9\u00aa\7(\2\2\u00aa$\3\2\2\2\u00ab"+
		"\u00ac\7-\2\2\u00ac&\3\2\2\2\u00ad\u00ae\7/\2\2\u00ae(\3\2\2\2\u00af\u00b0"+
		"\7,\2\2\u00b0*\3\2\2\2\u00b1\u00b2\7\61\2\2\u00b2,\3\2\2\2\u00b3\u00b4"+
		"\7`\2\2\u00b4.\3\2\2\2\u00b5\u00b6\7\'\2\2\u00b6\60\3\2\2\2\u00b7\u00b8"+
		"\7&\2\2\u00b8\62\3\2\2\2\u00b9\u00ba\7#\2\2\u00ba\64\3\2\2\2\u00bb\u00bc"+
		"\7<\2\2\u00bc\66\3\2\2\2\u00bd\u00be\7a\2\2\u00be8\3\2\2\2\u00bf\u00c0"+
		"\7B\2\2\u00c0:\3\2\2\2\u00c1\u00c2\7.\2\2\u00c2<\3\2\2\2\u00c3\u00c4\7"+
		"\60\2\2\u00c4>\3\2\2\2\u00c5\u00c6\7=\2\2\u00c6@\3\2\2\2\u00c7\u00c8\7"+
		"*\2\2\u00c8B\3\2\2\2\u00c9\u00ca\7+\2\2\u00caD\3\2\2\2\u00cb\u00cc\7}"+
		"\2\2\u00ccF\3\2\2\2\u00cd\u00ce\7\177\2\2\u00ceH\3\2\2\2\u00cf\u00d0\7"+
		"]\2\2\u00d0J\3\2\2\2\u00d1\u00d2\7_\2\2\u00d2L\3\2\2\2\u00d3\u00d4\7<"+
		"\2\2\u00d4\u00d5\7?\2\2\u00d5N\3\2\2\2\u00d6\u00d7\7H\2\2\u00d7\u00d8"+
		"\7Q\2\2\u00d8\u00d9\7T\2\2\u00d9\u00da\7}\2\2\u00daP\3\2\2\2\u00db\u00e0"+
		"\7\"\2\2\u00dc\u00dd\7\17\2\2\u00dd\u00e0\7\f\2\2\u00de\u00e0\4\13\f\2"+
		"\u00df\u00db\3\2\2\2\u00df\u00dc\3\2\2\2\u00df\u00de\3\2\2\2\u00e0\u00e1"+
		"\3\2\2\2\u00e1\u00e2\b)\2\2\u00e2R\3\2\2\2\21\2X[_bgmsu\u0080\u0084\u0089"+
		"\u0092\u0094\u00df\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}