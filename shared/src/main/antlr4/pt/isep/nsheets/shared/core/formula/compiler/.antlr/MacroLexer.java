// Generated from c:\Pedro\1 - isep\2 ano - 2 semestre\trabalhos\LAPR4\Projeto\repositorio_turma\shared\src\main\antlr4\pt\isep\nsheets\shared\core\formula\compiler\Macro.g4 by ANTLR 4.7.1

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
public class MacroLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "FUNCTION", "LETTER", "CELL_REF", "NAMEGLOBAL", 
		"STRING", "QUOT", "NUMBER", "FRACTIONALPART", "DIGIT", "DIGITNOTZERO", 
		"EQ", "NEQ", "LTEQ", "GTEQ", "GT", "LT", "AMP", "PLUS", "MINUS", "MULTI", 
		"DIV", "POWER", "PERCENT", "ABS", "EXCL", "COLON", "UNDERSCORE", "ARROBA", 
		"COMMA", "DOT", "SEMI", "LPAR", "RPAR", "ICHA", "FCHA", "LBRACKET", "RBRACKET", 
		"ASSIGN", "FOR", "WS", "COMMENT"
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


	public MacroLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Macro.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u0103\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\6\5o\n\5\r\5\16\5p\3\6\3\6\3\7\5\7v\n\7\3\7\3\7\5\7z"+
		"\n\7\3\7\5\7}\n\7\3\7\6\7\u0080\n\7\r\7\16\7\u0081\3\b\3\b\6\b\u0086\n"+
		"\b\r\b\16\b\u0087\3\t\3\t\3\t\3\t\7\t\u008e\n\t\f\t\16\t\u0091\13\t\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\7\13\u0099\n\13\f\13\16\13\u009c\13\13\3\13\5"+
		"\13\u009f\n\13\3\13\3\13\3\13\5\13\u00a4\n\13\3\f\3\f\5\f\u00a8\n\f\3"+
		"\f\3\f\5\f\u00ac\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3"+
		"\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3"+
		"(\3)\3)\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\5,\u00f7\n,\3,\3,\3-\3-\7"+
		"-\u00fd\n-\f-\16-\u0100\13-\3-\3-\2\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\29\2;\35=\36?\37A C!E\"G#I$K%M&O\'Q(S)U*W+Y"+
		",\3\2\5\4\2C\\c|\3\2$$\4\2\f\f\17\17\2\u0110\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5a\3\2"+
		"\2\2\7h\3\2\2\2\tn\3\2\2\2\13r\3\2\2\2\ru\3\2\2\2\17\u0083\3\2\2\2\21"+
		"\u0089\3\2\2\2\23\u0094\3\2\2\2\25\u00a3\3\2\2\2\27\u00a7\3\2\2\2\31\u00ad"+
		"\3\2\2\2\33\u00af\3\2\2\2\35\u00b1\3\2\2\2\37\u00b3\3\2\2\2!\u00b6\3\2"+
		"\2\2#\u00b9\3\2\2\2%\u00bc\3\2\2\2\'\u00be\3\2\2\2)\u00c0\3\2\2\2+\u00c2"+
		"\3\2\2\2-\u00c4\3\2\2\2/\u00c6\3\2\2\2\61\u00c8\3\2\2\2\63\u00ca\3\2\2"+
		"\2\65\u00cc\3\2\2\2\67\u00ce\3\2\2\29\u00d0\3\2\2\2;\u00d2\3\2\2\2=\u00d4"+
		"\3\2\2\2?\u00d6\3\2\2\2A\u00d8\3\2\2\2C\u00da\3\2\2\2E\u00dc\3\2\2\2G"+
		"\u00de\3\2\2\2I\u00e0\3\2\2\2K\u00e2\3\2\2\2M\u00e4\3\2\2\2O\u00e6\3\2"+
		"\2\2Q\u00e8\3\2\2\2S\u00ea\3\2\2\2U\u00ed\3\2\2\2W\u00f6\3\2\2\2Y\u00fa"+
		"\3\2\2\2[\\\7O\2\2\\]\7c\2\2]^\7e\2\2^_\7t\2\2_`\7q\2\2`\4\3\2\2\2ab\7"+
		"t\2\2bc\7g\2\2cd\7v\2\2de\7w\2\2ef\7t\2\2fg\7p\2\2g\6\3\2\2\2hi\7E\2\2"+
		"ij\7c\2\2jk\7n\2\2kl\7n\2\2l\b\3\2\2\2mo\5\13\6\2nm\3\2\2\2op\3\2\2\2"+
		"pn\3\2\2\2pq\3\2\2\2q\n\3\2\2\2rs\t\2\2\2s\f\3\2\2\2tv\5\67\34\2ut\3\2"+
		"\2\2uv\3\2\2\2vw\3\2\2\2wy\5\13\6\2xz\5\13\6\2yx\3\2\2\2yz\3\2\2\2z|\3"+
		"\2\2\2{}\5\67\34\2|{\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~\u0080\5\31\r\2\177"+
		"~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\16\3\2\2\2\u0083\u0085\5? \2\u0084\u0086\5\13\6\2\u0085\u0084\3\2\2\2"+
		"\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\20"+
		"\3\2\2\2\u0089\u008f\5\23\n\2\u008a\u008b\7^\2\2\u008b\u008e\7$\2\2\u008c"+
		"\u008e\n\3\2\2\u008d\u008a\3\2\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0093\5\23\n\2\u0093\22\3\2\2\2\u0094\u0095\7$\2"+
		"\2\u0095\24\3\2\2\2\u0096\u009a\5\33\16\2\u0097\u0099\5\31\r\2\u0098\u0097"+
		"\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009f\5\27\f\2\u009e\u009d\3"+
		"\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a4\3\2\2\2\u00a0\u00a1\5\31\r\2\u00a1"+
		"\u00a2\5\27\f\2\u00a2\u00a4\3\2\2\2\u00a3\u0096\3\2\2\2\u00a3\u00a0\3"+
		"\2\2\2\u00a4\26\3\2\2\2\u00a5\u00a8\5A!\2\u00a6\u00a8\5C\"\2\u00a7\u00a5"+
		"\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\5\31\r\2"+
		"\u00aa\u00ac\5\31\r\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\30"+
		"\3\2\2\2\u00ad\u00ae\4\62;\2\u00ae\32\3\2\2\2\u00af\u00b0\4\63;\2\u00b0"+
		"\34\3\2\2\2\u00b1\u00b2\7?\2\2\u00b2\36\3\2\2\2\u00b3\u00b4\7>\2\2\u00b4"+
		"\u00b5\7@\2\2\u00b5 \3\2\2\2\u00b6\u00b7\7>\2\2\u00b7\u00b8\7?\2\2\u00b8"+
		"\"\3\2\2\2\u00b9\u00ba\7@\2\2\u00ba\u00bb\7?\2\2\u00bb$\3\2\2\2\u00bc"+
		"\u00bd\7@\2\2\u00bd&\3\2\2\2\u00be\u00bf\7>\2\2\u00bf(\3\2\2\2\u00c0\u00c1"+
		"\7(\2\2\u00c1*\3\2\2\2\u00c2\u00c3\7-\2\2\u00c3,\3\2\2\2\u00c4\u00c5\7"+
		"/\2\2\u00c5.\3\2\2\2\u00c6\u00c7\7,\2\2\u00c7\60\3\2\2\2\u00c8\u00c9\7"+
		"\61\2\2\u00c9\62\3\2\2\2\u00ca\u00cb\7`\2\2\u00cb\64\3\2\2\2\u00cc\u00cd"+
		"\7\'\2\2\u00cd\66\3\2\2\2\u00ce\u00cf\7&\2\2\u00cf8\3\2\2\2\u00d0\u00d1"+
		"\7#\2\2\u00d1:\3\2\2\2\u00d2\u00d3\7<\2\2\u00d3<\3\2\2\2\u00d4\u00d5\7"+
		"a\2\2\u00d5>\3\2\2\2\u00d6\u00d7\7B\2\2\u00d7@\3\2\2\2\u00d8\u00d9\7."+
		"\2\2\u00d9B\3\2\2\2\u00da\u00db\7\60\2\2\u00dbD\3\2\2\2\u00dc\u00dd\7"+
		"=\2\2\u00ddF\3\2\2\2\u00de\u00df\7*\2\2\u00dfH\3\2\2\2\u00e0\u00e1\7+"+
		"\2\2\u00e1J\3\2\2\2\u00e2\u00e3\7}\2\2\u00e3L\3\2\2\2\u00e4\u00e5\7\177"+
		"\2\2\u00e5N\3\2\2\2\u00e6\u00e7\7]\2\2\u00e7P\3\2\2\2\u00e8\u00e9\7_\2"+
		"\2\u00e9R\3\2\2\2\u00ea\u00eb\7<\2\2\u00eb\u00ec\7?\2\2\u00ecT\3\2\2\2"+
		"\u00ed\u00ee\7H\2\2\u00ee\u00ef\7Q\2\2\u00ef\u00f0\7T\2\2\u00f0\u00f1"+
		"\7}\2\2\u00f1V\3\2\2\2\u00f2\u00f7\7\"\2\2\u00f3\u00f4\7\17\2\2\u00f4"+
		"\u00f7\7\f\2\2\u00f5\u00f7\4\13\f\2\u00f6\u00f2\3\2\2\2\u00f6\u00f3\3"+
		"\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\b,\2\2\u00f9"+
		"X\3\2\2\2\u00fa\u00fe\5E#\2\u00fb\u00fd\n\4\2\2\u00fc\u00fb\3\2\2\2\u00fd"+
		"\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\3\2"+
		"\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\b-\2\2\u0102Z\3\2\2\2\22\2puy|\u0081"+
		"\u0087\u008d\u008f\u009a\u009e\u00a3\u00a7\u00ab\u00f6\u00fe\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}