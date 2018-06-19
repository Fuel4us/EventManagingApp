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
		VAR=1, FUNCTION=2, CELL_REF=3, STRING=4, QUOT=5, NUMBER=6, EQ=7, NEQ=8, 
		LTEQ=9, GTEQ=10, GT=11, LT=12, AMP=13, PLUS=14, MINUS=15, MULTI=16, DIV=17, 
		POWER=18, PERCENT=19, COLON=20, ATTRIB=21, COMMA=22, SEMI=23, LPAR=24, 
		RPAR=25, LBRACKET=26, RBRACKET=27, STARTER=28, MACRO=29, UNDER=30, WS=31, 
		LINECOMMENT=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "VAR", "FUNCTION", "CELL_REF", "STRING", "QUOT", "NUMBER", "DIGIT", 
		"EQ", "NEQ", "LTEQ", "GTEQ", "GT", "LT", "AMP", "PLUS", "MINUS", "MULTI", 
		"DIV", "POWER", "PERCENT", "ABS", "EXCL", "COLON", "ATTRIB", "COMMA", 
		"SEMI", "LPAR", "RPAR", "LBRACKET", "RBRACKET", "STARTER", "MACRO", "UNDER", 
		"WS", "LINECOMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'\"'", null, "'='", "'<>'", "'<='", "'>='", 
		"'>'", "'<'", "'&'", "'+'", "'-'", "'*'", "'/'", "'^'", "'%'", "':'", 
		"':='", "','", "';'", "'('", "')'", "'{'", "'}'", "'|'", "'macro'", "'_'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "VAR", "FUNCTION", "CELL_REF", "STRING", "QUOT", "NUMBER", "EQ", 
		"NEQ", "LTEQ", "GTEQ", "GT", "LT", "AMP", "PLUS", "MINUS", "MULTI", "DIV", 
		"POWER", "PERCENT", "COLON", "ATTRIB", "COMMA", "SEMI", "LPAR", "RPAR", 
		"LBRACKET", "RBRACKET", "STARTER", "MACRO", "UNDER", "WS", "LINECOMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u00d4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\3\3\3\3\3\3\3\7\3R\n\3\f\3\16"+
		"\3U\13\3\3\4\3\4\6\4Y\n\4\r\4\16\4Z\3\5\5\5^\n\5\3\5\3\5\5\5b\n\5\3\5"+
		"\5\5e\n\5\3\5\6\5h\n\5\r\5\16\5i\3\6\3\6\3\6\3\6\7\6p\n\6\f\6\16\6s\13"+
		"\6\3\6\3\6\3\7\3\7\3\b\6\bz\n\b\r\b\16\b{\3\b\3\b\6\b\u0080\n\b\r\b\16"+
		"\b\u0081\5\b\u0084\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3#\3#\3$\3$\3$\3$\5$\u00c8\n$\3$\3$\3%\3%\7%\u00ce"+
		"\n%\f%\16%\u00d1\13%\3%\3%\2\2&\3\2\5\3\7\4\t\5\13\6\r\7\17\b\21\2\23"+
		"\t\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\2/\2\61"+
		"\26\63\27\65\30\67\319\32;\33=\34?\35A\36C\37E G!I\"\3\2\5\4\2C\\c|\3"+
		"\2$$\4\2\f\f\17\17\2\u00de\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\3K\3\2\2"+
		"\2\5M\3\2\2\2\7V\3\2\2\2\t]\3\2\2\2\13k\3\2\2\2\rv\3\2\2\2\17y\3\2\2\2"+
		"\21\u0085\3\2\2\2\23\u0087\3\2\2\2\25\u0089\3\2\2\2\27\u008c\3\2\2\2\31"+
		"\u008f\3\2\2\2\33\u0092\3\2\2\2\35\u0094\3\2\2\2\37\u0096\3\2\2\2!\u0098"+
		"\3\2\2\2#\u009a\3\2\2\2%\u009c\3\2\2\2\'\u009e\3\2\2\2)\u00a0\3\2\2\2"+
		"+\u00a2\3\2\2\2-\u00a4\3\2\2\2/\u00a6\3\2\2\2\61\u00a8\3\2\2\2\63\u00aa"+
		"\3\2\2\2\65\u00ad\3\2\2\2\67\u00af\3\2\2\29\u00b1\3\2\2\2;\u00b3\3\2\2"+
		"\2=\u00b5\3\2\2\2?\u00b7\3\2\2\2A\u00b9\3\2\2\2C\u00bb\3\2\2\2E\u00c1"+
		"\3\2\2\2G\u00c7\3\2\2\2I\u00cb\3\2\2\2KL\t\2\2\2L\4\3\2\2\2MN\5E#\2NS"+
		"\5\3\2\2OR\5\3\2\2PR\5\17\b\2QO\3\2\2\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2"+
		"ST\3\2\2\2T\6\3\2\2\2US\3\2\2\2VX\7?\2\2WY\5\3\2\2XW\3\2\2\2YZ\3\2\2\2"+
		"ZX\3\2\2\2Z[\3\2\2\2[\b\3\2\2\2\\^\5-\27\2]\\\3\2\2\2]^\3\2\2\2^_\3\2"+
		"\2\2_a\5\3\2\2`b\5\3\2\2a`\3\2\2\2ab\3\2\2\2bd\3\2\2\2ce\5-\27\2dc\3\2"+
		"\2\2de\3\2\2\2eg\3\2\2\2fh\5\21\t\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3"+
		"\2\2\2j\n\3\2\2\2kq\5\r\7\2lm\7^\2\2mp\7$\2\2np\n\3\2\2ol\3\2\2\2on\3"+
		"\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\5\r\7\2u\f"+
		"\3\2\2\2vw\7$\2\2w\16\3\2\2\2xz\5\21\t\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2"+
		"{|\3\2\2\2|\u0083\3\2\2\2}\177\5\65\33\2~\u0080\5\21\t\2\177~\3\2\2\2"+
		"\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084"+
		"\3\2\2\2\u0083}\3\2\2\2\u0083\u0084\3\2\2\2\u0084\20\3\2\2\2\u0085\u0086"+
		"\4\62;\2\u0086\22\3\2\2\2\u0087\u0088\7?\2\2\u0088\24\3\2\2\2\u0089\u008a"+
		"\7>\2\2\u008a\u008b\7@\2\2\u008b\26\3\2\2\2\u008c\u008d\7>\2\2\u008d\u008e"+
		"\7?\2\2\u008e\30\3\2\2\2\u008f\u0090\7@\2\2\u0090\u0091\7?\2\2\u0091\32"+
		"\3\2\2\2\u0092\u0093\7@\2\2\u0093\34\3\2\2\2\u0094\u0095\7>\2\2\u0095"+
		"\36\3\2\2\2\u0096\u0097\7(\2\2\u0097 \3\2\2\2\u0098\u0099\7-\2\2\u0099"+
		"\"\3\2\2\2\u009a\u009b\7/\2\2\u009b$\3\2\2\2\u009c\u009d\7,\2\2\u009d"+
		"&\3\2\2\2\u009e\u009f\7\61\2\2\u009f(\3\2\2\2\u00a0\u00a1\7`\2\2\u00a1"+
		"*\3\2\2\2\u00a2\u00a3\7\'\2\2\u00a3,\3\2\2\2\u00a4\u00a5\7&\2\2\u00a5"+
		".\3\2\2\2\u00a6\u00a7\7#\2\2\u00a7\60\3\2\2\2\u00a8\u00a9\7<\2\2\u00a9"+
		"\62\3\2\2\2\u00aa\u00ab\7<\2\2\u00ab\u00ac\7?\2\2\u00ac\64\3\2\2\2\u00ad"+
		"\u00ae\7.\2\2\u00ae\66\3\2\2\2\u00af\u00b0\7=\2\2\u00b08\3\2\2\2\u00b1"+
		"\u00b2\7*\2\2\u00b2:\3\2\2\2\u00b3\u00b4\7+\2\2\u00b4<\3\2\2\2\u00b5\u00b6"+
		"\7}\2\2\u00b6>\3\2\2\2\u00b7\u00b8\7\177\2\2\u00b8@\3\2\2\2\u00b9\u00ba"+
		"\7~\2\2\u00baB\3\2\2\2\u00bb\u00bc\7o\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be"+
		"\7e\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7q\2\2\u00c0D\3\2\2\2\u00c1\u00c2"+
		"\7a\2\2\u00c2F\3\2\2\2\u00c3\u00c8\7\"\2\2\u00c4\u00c5\7\17\2\2\u00c5"+
		"\u00c8\7\f\2\2\u00c6\u00c8\4\13\f\2\u00c7\u00c3\3\2\2\2\u00c7\u00c4\3"+
		"\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\b$\2\2\u00ca"+
		"H\3\2\2\2\u00cb\u00cf\5\67\34\2\u00cc\u00ce\n\4\2\2\u00cd\u00cc\3\2\2"+
		"\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2"+
		"\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\b%\2\2\u00d3J\3\2\2\2\21\2QS"+
		"Z]adioq{\u0081\u0083\u00c7\u00cf\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}