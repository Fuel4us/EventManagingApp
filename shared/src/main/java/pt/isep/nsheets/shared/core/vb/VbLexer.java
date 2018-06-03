package pt.isep.nsheets.shared.core.vb;

// Generated from Vb.g4 by ANTLR 4.2.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VbLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, TYPE_INT=3, TYPE_FLOAT=4, TYPE_STRING=5, OR=6, AND=7, 
		EQ=8, NEQ=9, GT=10, LT=11, GTEQ=12, LTEQ=13, PLUS=14, MINUS=15, MULT=16, 
		DIV=17, MOD=18, POW=19, NOT=20, SCOL=21, ASSIGN=22, OPAR=23, CPAR=24, 
		OPENIF=25, CLOSEIF=26, ENDWHILE=27, TRUE=28, FALSE=29, NIL=30, IF=31, 
		ELSE=32, WHILE=33, LOG=34, ID=35, INT=36, FLOAT=37, STRING=38, COMMENT=39, 
		SPACE=40, OTHER=41;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'As'", "'Dim'", "'Integer'", "'Float'", "'String'", "'||'", "'&&'", "'=='", 
		"'<>'", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'^'", "'!'", "';'", "'='", "'('", "')'", "'Then'", "CLOSEIF", "ENDWHILE", 
		"'true'", "'false'", "'nil'", "'If'", "'Else'", "'While'", "'Log'", "ID", 
		"INT", "FLOAT", "STRING", "COMMENT", "SPACE", "OTHER"
	};
	public static final String[] ruleNames = {
		"T__1", "T__0", "TYPE_INT", "TYPE_FLOAT", "TYPE_STRING", "OR", "AND", 
		"EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", "MINUS", "MULT", "DIV", 
		"MOD", "POW", "NOT", "SCOL", "ASSIGN", "OPAR", "CPAR", "OPENIF", "CLOSEIF", 
		"ENDWHILE", "TRUE", "FALSE", "NIL", "IF", "ELSE", "WHILE", "LOG", "ID", 
		"INT", "FLOAT", "STRING", "COMMENT", "SPACE", "OTHER"
	};


	public VbLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Vb.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2+\u0113\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3"+
		"\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3"+
		"#\3#\3$\5$\u00d8\n$\3$\3$\7$\u00dc\n$\f$\16$\u00df\13$\3%\6%\u00e2\n%"+
		"\r%\16%\u00e3\3&\6&\u00e7\n&\r&\16&\u00e8\3&\3&\7&\u00ed\n&\f&\16&\u00f0"+
		"\13&\3&\3&\6&\u00f4\n&\r&\16&\u00f5\5&\u00f8\n&\3\'\3\'\3\'\3\'\7\'\u00fe"+
		"\n\'\f\'\16\'\u0101\13\'\3\'\3\'\3(\3(\7(\u0107\n(\f(\16(\u010a\13(\3"+
		"(\3(\3)\3)\3)\3)\3*\3*\2\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+\3\2\b\5\2C\\aac|"+
		"\6\2\62;C\\aac|\3\2\62;\5\2\f\f\17\17$$\4\2\f\f\17\17\5\2\13\f\17\17\""+
		"\"\u011c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\3U\3\2\2\2\5X\3\2\2\2\7\\\3\2\2\2\td\3\2\2\2\13j\3\2\2\2\rq\3"+
		"\2\2\2\17t\3\2\2\2\21w\3\2\2\2\23z\3\2\2\2\25}\3\2\2\2\27\177\3\2\2\2"+
		"\31\u0081\3\2\2\2\33\u0084\3\2\2\2\35\u0087\3\2\2\2\37\u0089\3\2\2\2!"+
		"\u008b\3\2\2\2#\u008d\3\2\2\2%\u008f\3\2\2\2\'\u0091\3\2\2\2)\u0093\3"+
		"\2\2\2+\u0095\3\2\2\2-\u0097\3\2\2\2/\u0099\3\2\2\2\61\u009b\3\2\2\2\63"+
		"\u009d\3\2\2\2\65\u00a2\3\2\2\2\67\u00aa\3\2\2\29\u00b5\3\2\2\2;\u00ba"+
		"\3\2\2\2=\u00c0\3\2\2\2?\u00c4\3\2\2\2A\u00c7\3\2\2\2C\u00cc\3\2\2\2E"+
		"\u00d2\3\2\2\2G\u00d7\3\2\2\2I\u00e1\3\2\2\2K\u00f7\3\2\2\2M\u00f9\3\2"+
		"\2\2O\u0104\3\2\2\2Q\u010d\3\2\2\2S\u0111\3\2\2\2UV\7C\2\2VW\7u\2\2W\4"+
		"\3\2\2\2XY\7F\2\2YZ\7k\2\2Z[\7o\2\2[\6\3\2\2\2\\]\7K\2\2]^\7p\2\2^_\7"+
		"v\2\2_`\7g\2\2`a\7i\2\2ab\7g\2\2bc\7t\2\2c\b\3\2\2\2de\7H\2\2ef\7n\2\2"+
		"fg\7q\2\2gh\7c\2\2hi\7v\2\2i\n\3\2\2\2jk\7U\2\2kl\7v\2\2lm\7t\2\2mn\7"+
		"k\2\2no\7p\2\2op\7i\2\2p\f\3\2\2\2qr\7~\2\2rs\7~\2\2s\16\3\2\2\2tu\7("+
		"\2\2uv\7(\2\2v\20\3\2\2\2wx\7?\2\2xy\7?\2\2y\22\3\2\2\2z{\7>\2\2{|\7@"+
		"\2\2|\24\3\2\2\2}~\7@\2\2~\26\3\2\2\2\177\u0080\7>\2\2\u0080\30\3\2\2"+
		"\2\u0081\u0082\7@\2\2\u0082\u0083\7?\2\2\u0083\32\3\2\2\2\u0084\u0085"+
		"\7>\2\2\u0085\u0086\7?\2\2\u0086\34\3\2\2\2\u0087\u0088\7-\2\2\u0088\36"+
		"\3\2\2\2\u0089\u008a\7/\2\2\u008a \3\2\2\2\u008b\u008c\7,\2\2\u008c\""+
		"\3\2\2\2\u008d\u008e\7\61\2\2\u008e$\3\2\2\2\u008f\u0090\7\'\2\2\u0090"+
		"&\3\2\2\2\u0091\u0092\7`\2\2\u0092(\3\2\2\2\u0093\u0094\7#\2\2\u0094*"+
		"\3\2\2\2\u0095\u0096\7=\2\2\u0096,\3\2\2\2\u0097\u0098\7?\2\2\u0098.\3"+
		"\2\2\2\u0099\u009a\7*\2\2\u009a\60\3\2\2\2\u009b\u009c\7+\2\2\u009c\62"+
		"\3\2\2\2\u009d\u009e\7V\2\2\u009e\u009f\7j\2\2\u009f\u00a0\7g\2\2\u00a0"+
		"\u00a1\7p\2\2\u00a1\64\3\2\2\2\u00a2\u00a3\7G\2\2\u00a3\u00a4\7p\2\2\u00a4"+
		"\u00a5\7f\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\7\"\2\2\u00a7\u00a8\7K\2"+
		"\2\u00a8\u00a9\7h\2\2\u00a9\66\3\2\2\2\u00aa\u00ab\7G\2\2\u00ab\u00ac"+
		"\7p\2\2\u00ac\u00ad\7f\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7\"\2\2\u00af"+
		"\u00b0\7Y\2\2\u00b0\u00b1\7j\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3\7n\2\2"+
		"\u00b3\u00b4\7g\2\2\u00b48\3\2\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7t\2"+
		"\2\u00b7\u00b8\7w\2\2\u00b8\u00b9\7g\2\2\u00b9:\3\2\2\2\u00ba\u00bb\7"+
		"h\2\2\u00bb\u00bc\7c\2\2\u00bc\u00bd\7n\2\2\u00bd\u00be\7u\2\2\u00be\u00bf"+
		"\7g\2\2\u00bf<\3\2\2\2\u00c0\u00c1\7p\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3"+
		"\7n\2\2\u00c3>\3\2\2\2\u00c4\u00c5\7K\2\2\u00c5\u00c6\7h\2\2\u00c6@\3"+
		"\2\2\2\u00c7\u00c8\7G\2\2\u00c8\u00c9\7n\2\2\u00c9\u00ca\7u\2\2\u00ca"+
		"\u00cb\7g\2\2\u00cbB\3\2\2\2\u00cc\u00cd\7Y\2\2\u00cd\u00ce\7j\2\2\u00ce"+
		"\u00cf\7k\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7g\2\2\u00d1D\3\2\2\2\u00d2"+
		"\u00d3\7N\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5\7i\2\2\u00d5F\3\2\2\2\u00d6"+
		"\u00d8\7&\2\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2"+
		"\2\2\u00d9\u00dd\t\2\2\2\u00da\u00dc\t\3\2\2\u00db\u00da\3\2\2\2\u00dc"+
		"\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00deH\3\2\2\2"+
		"\u00df\u00dd\3\2\2\2\u00e0\u00e2\t\4\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e3"+
		"\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4J\3\2\2\2\u00e5"+
		"\u00e7\t\4\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e6\3\2"+
		"\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ee\7\60\2\2\u00eb"+
		"\u00ed\t\4\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2"+
		"\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f8\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1"+
		"\u00f3\7\60\2\2\u00f2\u00f4\t\4\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00f5\3"+
		"\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7"+
		"\u00e6\3\2\2\2\u00f7\u00f1\3\2\2\2\u00f8L\3\2\2\2\u00f9\u00ff\7$\2\2\u00fa"+
		"\u00fe\n\5\2\2\u00fb\u00fc\7$\2\2\u00fc\u00fe\7$\2\2\u00fd\u00fa\3\2\2"+
		"\2\u00fd\u00fb\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100"+
		"\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0103\7$\2\2\u0103"+
		"N\3\2\2\2\u0104\u0108\7%\2\2\u0105\u0107\n\6\2\2\u0106\u0105\3\2\2\2\u0107"+
		"\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010b\3\2"+
		"\2\2\u010a\u0108\3\2\2\2\u010b\u010c\b(\2\2\u010cP\3\2\2\2\u010d\u010e"+
		"\t\7\2\2\u010e\u010f\3\2\2\2\u010f\u0110\b)\2\2\u0110R\3\2\2\2\u0111\u0112"+
		"\13\2\2\2\u0112T\3\2\2\2\r\2\u00d7\u00dd\u00e3\u00e8\u00ee\u00f5\u00f7"+
		"\u00fd\u00ff\u0108\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}