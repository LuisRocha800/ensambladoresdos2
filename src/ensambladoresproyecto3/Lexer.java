/* The following code was generated by JFlex 1.3.5 on 05/12/22 22:13 */

package ensambladoresproyecto3;
import static ensambladoresproyecto3.Tokens.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.3.5
 * on 05/12/22 22:13 from the specification file
 * <tt>file:/C:/Users/Luis Angel Rocha/Desktop/ensambladoresdos2/src/ensambladoresproyecto3/Lexer.flex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  final public static int YYEOF = -1;

  /** initial size of the lookahead buffer */
  final private static int YY_BUFFERSIZE = 16384;

  /** lexical states */
  final public static int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  final private static char [] yycmap = {
     0,  0,  0,  0,  0,  0,  0,  0,  0, 43, 42,  0,  0, 43,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
    39,  0, 32,  0, 24,  0,  0, 33, 26, 28,  0, 37, 43, 27, 44,  0, 
    29, 31, 25, 25, 25, 25, 25, 25, 25, 25, 36,  1,  0,  0,  0, 40, 
     0,  2,  4,  5,  6, 12, 30, 20,  7,  9, 21, 45,  8, 16, 22, 17, 
    11, 41, 15, 10, 13, 19, 18, 14,  3, 38, 23, 34,  0, 35,  0, 24, 
     0,  2,  4,  5,  6, 12, 30, 20,  7,  9, 21, 45,  8, 16, 22, 17, 
    11, 41, 15, 10, 13, 19, 18, 14,  3, 38, 23,  0,  0,  0,  0,  0
  };

  /** 
   * Translates a state to a row index in the transition table
   */
  final private static int yy_rowMap [] = { 
        0,    46,    92,   138,   184,   230,   276,   322,   368,   414, 
      460,   506,   552,   598,   644,   690,   736,   782,   828,   874, 
      920,   966,  1012,  1058,  1104,  1150,  1196,  1242,   368,    46, 
     1288,  1334,  1242,  1380,  1426,   368,  1472,   368,  1518,  1564, 
     1610,  1656,  1702,  1748,  1794,  1840,  1886,  1932,  1978,  2024, 
     2070,  2116,  2162,   368,  2208,  2254,   828,  2300,  2300,  2346, 
     2392,   368,  2438,  2438,  2484,  2530,  2576,  2576,  2622,  2668, 
     2714,  2760,  2806,  2852,  2898,  2944,  2990,  3036,  3082,  3128, 
     3174,  3220,  3266,  3312,  3358,  3404,  1472,  3450,  3496,  3542, 
      368,  3588,  3634,  3680,  3726,   368,  3772,  3772,  3818,  3864, 
     3910,  3910,  3956,  4002,  4048,  4094,  4140,  4186,  4232,  4278, 
     4324,  4370,  4416,  4462,  4508,  4554,   368,  4600,  4646,    46, 
     4692,  3864,  4738,  4784,  4002,  4830,    46,  4876,  4922,  4968, 
     5014,  5060,  5106,  5152,  5198,  5244,  5290,  5336,  5382,  5428, 
     5474,  5520,  5566,    46,  5612,  5658,  5704,  5750,  5796,  5842, 
     5888,  5934,  5980,  6026,  4324,  4370,  6072,  6118,  6164,  6210, 
     6256,    46,  6302,  6348,  6394,  6440,  6486,  6532,    46,  6578, 
     6624,  6670,  6716,  6762,  6808,  6854,  6900,  6946,  6992,  7038, 
     7084,  7130,  5520,  7176,  7222,  7268,  7314,  7360,    46,  7406, 
     7452,  7498,  7544,  7590,  7636,  7682,  7728,  7774,    46,    46, 
     7820,  7866,  7912,  7958,  8004,  8050,  8096,  8142,  8188,  8234, 
     8280,  8326,  8372,  8418,  8464,  8510,  8556,  8602,  8648,  8694, 
     8740,  8786,  8832,  8878,  8924,  8970,  9016,  9062,  9108,  9154, 
     9200,  9246,    46,    46,  9292,  9338,    46,    46,  9384,  9430, 
     9476,  9522,  9568,  9614,  9660
  };

  /** 
   * The packed transition table of the DFA (part 0)
   */
  final private static String yy_packed0 = 
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\11\1\17\1\11"+
    "\1\20\4\11\1\21\3\11\1\22\1\23\1\24\1\2"+
    "\1\25\1\11\1\26\1\27\1\30\1\31\3\2\1\11"+
    "\1\32\1\2\1\11\2\32\1\33\1\11\56\0\52\3"+
    "\1\0\3\3\2\0\1\34\1\35\2\11\1\34\2\35"+
    "\21\11\3\0\3\11\4\0\1\36\1\0\1\11\2\0"+
    "\1\11\2\0\2\11\2\0\3\11\1\37\24\11\3\0"+
    "\3\11\4\0\1\36\1\0\1\11\2\0\1\11\2\0"+
    "\2\11\2\0\1\11\1\35\3\11\2\35\2\11\1\35"+
    "\16\11\3\0\3\11\4\0\1\36\1\0\1\40\2\0"+
    "\1\11\2\0\2\11\2\0\1\11\1\35\3\11\1\35"+
    "\1\41\1\11\1\35\3\11\1\34\2\11\1\42\10\11"+
    "\3\0\3\11\4\0\1\36\1\0\1\11\2\0\1\11"+
    "\2\0\2\11\2\0\1\43\1\35\1\44\2\11\2\35"+
    "\1\45\1\35\3\11\1\46\4\11\1\47\6\11\3\0"+
    "\3\11\4\0\1\36\1\0\1\11\2\0\1\11\2\0"+
    "\2\11\2\0\30\11\3\0\3\11\4\0\1\36\1\0"+
    "\1\11\2\0\1\11\2\0\2\11\2\0\4\11\1\50"+
    "\12\11\1\51\10\11\3\0\3\11\4\0\1\36\1\0"+
    "\1\11\2\0\1\11\2\0\2\11\2\0\4\11\1\52"+
    "\10\11\1\53\1\54\11\11\3\0\3\11\4\0\1\36"+
    "\1\0\1\11\2\0\1\11\2\0\2\11\2\0\5\11"+
    "\1\55\1\11\3\35\1\11\1\56\14\11\3\0\3\11"+
    "\4\0\1\36\1\0\1\11\2\0\1\11\2\0\2\11"+
    "\2\0\17\11\1\57\10\11\3\0\3\11\4\0\1\36"+
    "\1\0\1\11\2\0\1\11\2\0\2\11\2\0\10\11"+
    "\1\35\13\11\1\60\3\11\3\0\3\11\4\0\1\36"+
    "\1\0\1\11\2\0\1\61\2\0\2\11\2\0\17\11"+
    "\1\62\10\11\3\0\3\11\4\0\1\36\1\0\1\11"+
    "\2\0\1\11\2\0\2\11\2\0\17\11\1\63\10\11"+
    "\3\0\3\11\4\0\1\36\1\0\1\11\2\0\1\11"+
    "\2\0\2\11\2\0\1\64\2\11\1\65\2\11\1\66"+
    "\1\11\1\66\13\11\1\50\3\11\3\0\3\11\4\0"+
    "\1\36\1\0\1\11\2\0\1\11\2\0\2\11\2\0"+
    "\27\11\1\22\3\0\1\22\1\11\1\22\4\0\1\36"+
    "\1\0\1\11\2\0\1\11\2\0\2\11\33\0\1\67"+
    "\53\0\1\70\1\71\2\0\1\70\1\0\1\70\20\0"+
    "\1\72\1\11\1\73\2\72\5\11\1\72\14\11\1\74"+
    "\3\0\1\75\1\72\1\75\4\0\1\36\1\0\1\11"+
    "\2\0\1\11\2\0\2\11\2\0\2\11\1\76\24\11"+
    "\1\22\3\0\1\26\1\11\1\26\4\0\1\36\1\0"+
    "\1\11\2\0\1\11\2\0\2\11\40\77\1\100\6\77"+
    "\1\101\2\77\1\102\1\101\2\77\41\103\1\104\5\103"+
    "\1\105\2\103\1\106\1\105\2\103\2\0\1\107\1\0"+
    "\1\110\1\111\1\112\3\0\1\113\1\0\1\114\110\0"+
    "\1\32\2\0\2\32\4\0\3\11\1\115\1\116\3\11"+
    "\1\117\5\11\1\120\11\11\3\0\3\11\4\0\1\36"+
    "\1\0\1\11\2\0\1\11\2\0\2\11\2\0\4\11"+
    "\1\66\23\11\3\0\3\11\4\0\1\36\1\0\1\11"+
    "\2\0\1\11\2\0\2\11\2\0\5\11\1\121\22\11"+
    "\3\0\3\11\4\0\1\36\1\0\1\11\2\0\1\11"+
    "\2\0\2\11\2\0\13\11\1\122\14\11\3\0\3\11"+
    "\4\0\1\36\1\0\1\11\2\0\1\11\2\0\2\11"+
    "\2\0\4\11\1\123\23\11\3\0\3\11\4\0\1\36"+
    "\1\0\1\11\2\0\1\11\2\0\2\11\2\0\13\11"+
    "\1\124\14\11\3\0\3\11\4\0\1\36\1\0\1\11"+
    "\2\0\1\11\2\0\2\11\2\0\20\11\1\66\7\11"+
    "\3\0\3\11\4\0\1\36\1\0\1\11\2\0\1\11"+
    "\2\0\2\11\2\0\11\11\1\125\16\11\3\0\3\11"+
    "\4\0\1\36\1\0\1\11\2\0\1\11\2\0\2\11"+
    "\2\0\10\11\1\66\17\11\3\0\3\11\4\0\1\36"+
    "\1\0\1\11\2\0\1\11\2\0\2\11\2\0\17\11"+
    "\1\126\10\11\3\0\3\11\4\0\1\36\1\0\1\11"+
    "\2\0\1\11\2\0\2\11\2\0\7\11\1\127\20\11"+
    "\3\0\3\11\4\0\1\36\1\0\1\11\2\0\1\11"+
    "\2\0\2\11\2\0\12\11\1\130\15\11\3\0\3\11"+
    "\4\0\1\36\1\0\1\11\2\0\1\11\2\0\2\11"+
    "\2\0\21\11\1\55\6\11\3\0\3\11\4\0\1\36"+
    "\1\0\1\11\2\0\1\11\2\0\2\11\2\0\6\11"+
    "\1\66\21\11\3\0\3\11\4\0\1\36\1\0\1\11"+
    "\2\0\1\11\2\0\2\11\2\0\1\131\3\11\1\66"+
    "\23\11\3\0\3\11\4\0\1\36\1\0\1\11\2\0"+
    "\1\11\2\0\2\11\2\0\11\11\1\66\16\11\3\0"+
    "\3\11\4\0\1\36\1\0\1\11\2\0\1\11\2\0"+
    "\2\11\2\0\4\11\1\132\23\11\3\0\3\11\4\0"+
    "\1\36\1\0\1\11\2\0\1\11\2\0\2\11\2\0"+
    "\21\11\1\133\6\11\3\0\3\11\4\0\1\36\1\0"+
    "\1\11\2\0\1\11\2\0\2\11\2\0\15\11\1\134"+
    "\12\11\3\0\3\11\4\0\1\36\1\0\1\11\2\0"+
    "\1\11\2\0\2\11\2\0\20\11\1\135\7\11\3\0"+
    "\3\11\4\0\1\36\1\0\1\11\2\0\1\11\2\0"+
    "\2\11\2\0\12\11\1\66\15\11\3\0\3\11\4\0"+
    "\1\36\1\0\1\11\2\0\1\11\2\0\2\11\2\0"+
    "\1\11\1\136\26\11\3\0\3\11\4\0\1\36\1\0"+
    "\1\11\2\0\1\11\2\0\2\11\31\0\1\137\3\0"+
    "\1\137\1\0\1\137\47\0\1\70\3\0\1\70\1\0"+
    "\1\70\20\0\1\72\1\11\3\72\1\140\4\11\1\72"+
    "\14\11\1\72\3\0\3\72\4\0\1\36\1\0\1\11"+
    "\2\0\1\11\2\0\2\11\2\0\1\72\1\11\3\72"+
    "\1\140\4\11\1\72\14\11\1\74\3\0\1\74\1\72"+
    "\1\74\4\0\1\36\1\0\1\11\2\0\1\11\2\0"+
    "\2\11\2\0\1\72\1\11\1\73\2\72\1\140\4\11"+
    "\1\72\14\11\1\74\3\0\1\75\1\72\1\75\4\0"+
    "\1\36\1\0\1\11\2\0\1\11\2\0\2\11\40\77"+
    "\1\100\11\77\1\0\3\77\40\141\1\142\6\141\1\101"+
    "\2\141\1\143\1\101\2\141\47\144\1\143\2\144\2\143"+
    "\2\144\41\103\1\104\10\103\1\0\3\103\41\145\1\146"+
    "\5\145\1\105\2\145\1\147\1\105\2\145\47\150\1\147"+
    "\2\150\2\147\2\150\3\0\1\151\3\0\2\151\50\0"+
    "\1\151\3\0\2\151\2\0\1\151\45\0\1\151\3\0"+
    "\2\151\1\0\1\151\46\0\1\151\3\0\4\151\54\0"+
    "\3\151\54\0\1\151\45\0\17\11\1\152\10\11\3\0"+
    "\3\11\4\0\1\36\1\0\1\11\2\0\1\11\2\0"+
    "\2\11\2\0\1\153\27\11\3\0\3\11\4\0\1\36"+
    "\1\0\1\11\2\0\1\11\2\0\2\11\2\0\13\11"+
    "\1\154\14\11\3\0\3\11\4\0\1\36\1\0\1\11"+
    "\2\0\1\11\2\0\2\11\2\0\17\11\1\155\10\11"+
    "\3\0\3\11\4\0\1\36\1\0\1\11\2\0\1\11"+
    "\2\0\2\11\2\0\22\11\1\66\5\11\3\0\3\11"+
    "\4\0\1\36\1\0\1\11\2\0\1\11\2\0\2\11"+
    "\2\0\12\11\1\156\15\11\3\0\3\11\4\0\1\36"+
    "\1\0\1\11\2\0\1\11\2\0\2\11\2\0\12\11"+
    "\1\157\15\11\3\0\3\11\4\0\1\36\1\0\1\11"+
    "\2\0\1\11\2\0\2\11\2\0\1\160\27\11\3\0"+
    "\3\11\4\0\1\36\1\0\1\11\2\0\1\11\2\0"+
    "\2\11\2\0\30\11\1\161\2\0\3\11\4\0\1\36"+
    "\1\0\1\11\1\162\1\0\1\11\2\0\2\11\2\0"+
    "\11\11\1\163\16\11\3\0\3\11\4\0\1\36\1\0"+
    "\1\11\2\0\1\11\2\0\2\11\2\0\13\11\1\66"+
    "\14\11\3\0\3\11\4\0\1\36\1\0\1\11\2\0"+
    "\1\11\2\0\2\11\2\0\3\11\1\164\24\11\3\0"+
    "\3\11\4\0\1\36\1\0\1\11\2\0\1\11\2\0"+
    "\2\11\2\0\10\11\1\165\17\11\3\0\3\11\4\0"+
    "\1\36\1\0\1\11\2\0\1\11\2\0\2\11\2\0"+
    "\4\11\1\166\23\11\3\0\3\11\4\0\1\36\1\0"+
    "\1\11\2\0\1\11\2\0\2\11\2\0\10\11\1\167"+
    "\17\11\3\0\3\11\4\0\1\36\1\0\1\11\2\0"+
    "\1\11\2\0\2\11\2\0\25\11\1\66\2\11\3\0"+
    "\3\11\4\0\1\36\1\0\1\11\2\0\1\11\2\0"+
    "\2\11\31\0\1\137\2\0\1\170\1\137\1\0\1\137"+
    "\16\0\40\141\1\142\11\141\1\171\3\141\40\144\1\172"+
    "\6\144\1\143\2\144\2\143\51\144\1\173\2\144\1\171"+
    "\1\173\2\144\41\145\1\146\10\145\1\174\3\145\41\150"+
    "\1\175\5\150\1\147\2\150\2\147\51\150\1\176\2\150"+
    "\1\174\1\176\2\150\43\0\1\177\1\0\1\200\12\0"+
    "\4\11\1\201\23\11\3\0\3\11\4\0\1\36\1\0"+
    "\1\11\2\0\1\11\2\0\2\11\2\0\13\11\1\202"+
    "\14\11\3\0\3\11\4\0\1\36\1\0\1\11\2\0"+
    "\1\11\2\0\2\11\2\0\1\203\27\11\3\0\3\11"+
    "\4\0\1\36\1\0\1\11\2\0\1\11\2\0\2\11"+
    "\2\0\4\11\1\204\23\11\3\0\3\11\4\0\1\36"+
    "\1\0\1\11\2\0\1\11\2\0\2\11\2\0\30\11"+
    "\3\0\3\11\4\0\1\36\1\0\1\11\1\205\1\0"+
    "\1\11\2\0\2\11\2\0\30\11\3\0\3\11\4\0"+
    "\1\36\1\0\1\11\1\206\1\0\1\11\2\0\2\11"+
    "\2\0\30\11\3\0\3\11\4\0\1\36\1\0\1\11"+
    "\1\207\1\0\1\11\2\0\2\11\31\0\1\210\3\0"+
    "\1\211\1\0\1\212\1\0\1\213\6\0\1\214\37\0"+
    "\1\215\25\0\24\11\1\64\3\11\3\0\3\11\4\0"+
    "\1\36\1\0\1\11\2\0\1\11\2\0\2\11\2\0"+
    "\30\11\3\0\3\11\4\0\1\36\1\0\1\11\2\0"+
    "\1\11\2\0\1\11\1\216\2\0\30\11\3\0\3\11"+
    "\4\0\1\36\1\0\1\11\1\217\1\0\1\11\2\0"+
    "\2\11\2\0\14\11\1\66\13\11\3\0\3\11\4\0"+
    "\1\36\1\0\1\11\2\0\1\11\2\0\2\11\40\0"+
    "\1\220\6\0\1\171\2\0\2\171\2\0\40\144\1\172"+
    "\6\144\1\173\2\144\1\171\1\173\2\144\41\0\1\220"+
    "\5\0\1\174\2\0\2\174\2\0\41\150\1\175\5\150"+
    "\1\176\2\150\1\174\1\176\2\150\2\0\1\221\1\0"+
    "\1\222\1\223\1\224\3\0\1\225\1\0\1\226\14\0"+
    "\1\227\1\230\2\0\1\231\1\0\1\232\20\0\12\11"+
    "\1\233\15\11\3\0\3\11\4\0\1\36\1\0\1\11"+
    "\2\0\1\11\2\0\2\11\2\0\1\234\27\11\3\0"+
    "\3\11\4\0\1\36\1\0\1\11\2\0\1\11\2\0"+
    "\2\11\2\0\3\11\1\235\24\11\3\0\3\11\4\0"+
    "\1\36\1\0\1\11\2\0\1\11\2\0\2\11\2\0"+
    "\12\11\1\236\15\11\3\0\3\11\4\0\1\36\1\0"+
    "\1\11\2\0\1\11\2\0\2\11\13\0\1\237\54\0"+
    "\1\240\55\0\1\241\74\0\1\210\2\0\1\242\1\210"+
    "\1\0\1\210\20\0\1\243\1\0\1\244\2\243\5\0"+
    "\1\243\14\0\1\245\2\0\1\242\1\246\1\243\1\246"+
    "\22\0\1\247\24\0\1\210\2\0\1\242\1\212\1\0"+
    "\1\212\20\0\30\250\2\0\1\251\3\250\1\0\1\252"+
    "\4\0\1\250\1\253\1\0\1\250\2\0\2\250\50\0"+
    "\1\254\36\0\1\210\3\0\1\211\1\0\1\212\1\0"+
    "\1\255\16\0\30\11\3\0\3\11\4\0\1\36\1\0"+
    "\1\11\1\256\1\0\1\11\2\0\2\11\13\0\1\257"+
    "\45\0\1\260\3\0\2\260\50\0\1\260\3\0\2\260"+
    "\2\0\1\260\45\0\1\260\3\0\2\260\1\0\1\260"+
    "\46\0\1\260\3\0\4\260\54\0\3\260\54\0\1\260"+
    "\74\0\1\227\3\0\1\227\1\0\1\227\3\0\1\177"+
    "\45\0\1\261\24\0\1\262\1\0\1\263\2\262\5\0"+
    "\1\262\14\0\1\264\3\0\1\265\1\262\1\265\3\0"+
    "\1\177\16\0\1\266\24\0\1\227\3\0\1\232\1\0"+
    "\1\232\3\0\1\177\14\0\30\11\3\0\3\11\4\0"+
    "\1\36\1\0\1\11\2\0\1\11\2\0\1\11\1\267"+
    "\2\0\6\11\1\270\21\11\3\0\3\11\4\0\1\36"+
    "\1\0\1\11\2\0\1\11\2\0\2\11\15\0\1\271"+
    "\54\0\1\272\55\0\1\273\43\0\1\243\1\0\3\243"+
    "\1\274\4\0\1\243\14\0\1\243\3\0\3\243\20\0"+
    "\1\243\1\0\3\243\1\274\4\0\1\243\14\0\1\243"+
    "\2\0\1\275\3\243\20\0\1\243\1\0\3\243\1\274"+
    "\4\0\1\243\14\0\1\245\2\0\1\242\1\245\1\243"+
    "\1\245\20\0\1\243\1\0\1\244\2\243\1\274\4\0"+
    "\1\243\14\0\1\245\2\0\1\242\1\246\1\243\1\246"+
    "\52\0\1\275\23\0\30\250\3\0\3\250\1\0\1\276"+
    "\4\0\1\250\2\0\1\250\2\0\2\250\34\0\1\251"+
    "\62\0\1\252\64\0\1\252\7\0\30\250\3\0\3\250"+
    "\6\0\1\250\2\0\1\250\2\0\2\250\12\0\1\277"+
    "\60\0\1\300\103\0\1\177\1\0\1\301\41\0\1\302"+
    "\3\0\1\302\1\0\1\302\20\0\1\262\1\0\3\262"+
    "\1\266\4\0\1\262\14\0\1\262\3\0\3\262\20\0"+
    "\1\262\1\0\3\262\1\266\4\0\1\262\14\0\1\262"+
    "\3\0\3\262\3\0\1\177\14\0\1\262\1\0\3\262"+
    "\1\266\4\0\1\262\14\0\1\264\3\0\1\264\1\262"+
    "\1\264\3\0\1\177\14\0\1\262\1\0\1\263\2\262"+
    "\1\266\4\0\1\262\14\0\1\264\3\0\1\265\1\262"+
    "\1\265\3\0\1\177\55\0\1\177\14\0\30\11\3\0"+
    "\3\11\4\0\1\36\1\0\1\11\1\303\1\0\1\11"+
    "\2\0\2\11\17\0\1\304\62\0\1\305\55\0\1\306"+
    "\65\0\1\307\55\0\1\310\35\0\1\311\60\0\1\312"+
    "\67\0\1\227\1\230\2\0\1\231\1\0\1\232\47\0"+
    "\1\302\2\0\1\266\1\302\1\0\1\302\30\0\1\313"+
    "\105\0\1\314\4\0\1\315\26\0\1\316\55\0\1\317"+
    "\61\0\1\320\73\0\1\321\4\0\1\322\26\0\1\323"+
    "\37\0\1\324\1\0\1\325\1\326\1\327\3\0\1\330"+
    "\1\0\1\331\103\0\1\314\27\0\1\332\55\0\1\333"+
    "\61\0\1\334\37\0\1\335\1\0\1\336\1\337\1\340"+
    "\3\0\1\341\1\0\1\342\103\0\1\321\15\0\1\343"+
    "\56\0\1\266\3\0\2\266\50\0\1\266\3\0\2\266"+
    "\2\0\1\266\45\0\1\266\3\0\2\266\1\0\1\266"+
    "\46\0\1\266\3\0\4\266\54\0\3\266\54\0\1\266"+
    "\71\0\1\344\55\0\1\345\43\0\1\346\44\0\1\347"+
    "\3\0\2\347\50\0\1\347\3\0\2\347\2\0\1\347"+
    "\45\0\1\347\3\0\2\347\1\0\1\347\46\0\1\347"+
    "\3\0\4\347\54\0\3\347\54\0\1\347\53\0\1\350"+
    "\62\0\1\351\55\0\1\352\66\0\1\353\72\0\1\177"+
    "\1\0\1\354\20\0\1\355\62\0\1\356\42\0\1\357"+
    "\1\0\1\360\1\361\1\362\3\0\1\363\1\0\1\364"+
    "\44\0\1\365\3\0\2\365\50\0\1\365\3\0\2\365"+
    "\2\0\1\365\45\0\1\365\3\0\2\365\1\0\1\365"+
    "\46\0\1\365\3\0\4\365\54\0\3\365\54\0\1\365"+
    "\110\0\1\301\10\0";

  /** 
   * The transition table of the DFA
   */
  final private static int yytrans [] = yy_unpack();


  /* error codes */
  final private static int YY_UNKNOWN_ERROR = 0;
  final private static int YY_ILLEGAL_STATE = 1;
  final private static int YY_NO_MATCH = 2;
  final private static int YY_PUSHBACK_2BIG = 3;

  /* error messages for the codes above */
  final private static String YY_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Internal error: unknown state",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * YY_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private final static byte YY_ATTRIBUTE[] = {
     0,  9,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  9,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  0,  1,  0,  1,  1,  1,  1,  1,  0,  1, 
     0,  0,  0,  1,  0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  0,  1, 
     0,  1,  0,  0,  0,  1,  0,  0,  0,  1,  1,  1,  1,  1,  1,  1, 
     0,  0,  1,  1,  1,  1,  1,  9,  0,  1,  0,  0,  1,  0,  9,  0, 
     1,  1,  1,  1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  0,  9, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  1,  1,  0,  0, 
     0,  9,  0,  0,  0,  0,  0,  0,  9,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  1,  1,  0,  0,  0,  0,  9,  0,  0,  0, 
     0,  0,  0,  1,  0,  0,  9,  9,  0,  1,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  9,  9,  0,  0,  9,  9,  0,  0, 
     0,  0,  0,  0,  0
  };

  /** the input device */
  private java.io.Reader yy_reader;

  /** the current state of the DFA */
  private int yy_state;

  /** the current lexical state */
  private int yy_lexical_state = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char yy_buffer[] = new char[YY_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int yy_markedPos;

  /** the textposition at the last state to be included in yytext */
  private int yy_pushbackPos;

  /** the current text position in the buffer */
  private int yy_currentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int yy_startRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int yy_endRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn; 

  /** 
   * yy_atBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean yy_atBOL = true;

  /** yy_atEOF == true <=> the scanner is at the EOF */
  private boolean yy_atEOF;

  /* user code: */
    public String lexeme;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.yy_reader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the split, compressed DFA transition table.
   *
   * @return the unpacked transition table
   */
  private static int [] yy_unpack() {
    int [] trans = new int[9706];
    int offset = 0;
    offset = yy_unpack(yy_packed0, offset, trans);
    return trans;
  }

  /** 
   * Unpacks the compressed DFA transition table.
   *
   * @param packed   the packed transition table
   * @return         the index of the last entry
   */
  private static int yy_unpack(String packed, int offset, int [] trans) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do trans[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   IOException  if any I/O-Error occurs
   */
  private boolean yy_refill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (yy_startRead > 0) {
      System.arraycopy(yy_buffer, yy_startRead, 
                       yy_buffer, 0, 
                       yy_endRead-yy_startRead);

      /* translate stored positions */
      yy_endRead-= yy_startRead;
      yy_currentPos-= yy_startRead;
      yy_markedPos-= yy_startRead;
      yy_pushbackPos-= yy_startRead;
      yy_startRead = 0;
    }

    /* is the buffer big enough? */
    if (yy_currentPos >= yy_buffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[yy_currentPos*2];
      System.arraycopy(yy_buffer, 0, newBuffer, 0, yy_buffer.length);
      yy_buffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = yy_reader.read(yy_buffer, yy_endRead, 
                                            yy_buffer.length-yy_endRead);

    if (numRead < 0) {
      return true;
    }
    else {
      yy_endRead+= numRead;  
      return false;
    }
  }


  /**
   * Closes the input stream.
   */
  final public void yyclose() throws java.io.IOException {
    yy_atEOF = true;            /* indicate end of file */
    yy_endRead = yy_startRead;  /* invalidate buffer    */

    if (yy_reader != null)
      yy_reader.close();
  }


  /**
   * Closes the current stream, and resets the
   * scanner to read from a new input stream.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>YY_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  final public void yyreset(java.io.Reader reader) throws java.io.IOException {
    yyclose();
    yy_reader = reader;
    yy_atBOL  = true;
    yy_atEOF  = false;
    yy_endRead = yy_startRead = 0;
    yy_currentPos = yy_markedPos = yy_pushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    yy_lexical_state = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  final public int yystate() {
    return yy_lexical_state;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  final public void yybegin(int newState) {
    yy_lexical_state = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  final public String yytext() {
    return new String( yy_buffer, yy_startRead, yy_markedPos-yy_startRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  final public char yycharat(int pos) {
    return yy_buffer[yy_startRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  final public int yylength() {
    return yy_markedPos-yy_startRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void yy_ScanError(int errorCode) {
    String message;
    try {
      message = YY_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = YY_ERROR_MSG[YY_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  private void yypushback(int number)  {
    if ( number > yylength() )
      yy_ScanError(YY_PUSHBACK_2BIG);

    yy_markedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
    int yy_input;
    int yy_action;

    // cached fields:
    int yy_currentPos_l;
    int yy_startRead_l;
    int yy_markedPos_l;
    int yy_endRead_l = yy_endRead;
    char [] yy_buffer_l = yy_buffer;
    char [] yycmap_l = yycmap;

    int [] yytrans_l = yytrans;
    int [] yy_rowMap_l = yy_rowMap;
    byte [] yy_attr_l = YY_ATTRIBUTE;

    while (true) {
      yy_markedPos_l = yy_markedPos;

      boolean yy_r = false;
      for (yy_currentPos_l = yy_startRead; yy_currentPos_l < yy_markedPos_l;
                                                             yy_currentPos_l++) {
        switch (yy_buffer_l[yy_currentPos_l]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yy_r = false;
          break;
        case '\r':
          yyline++;
          yy_r = true;
          break;
        case '\n':
          if (yy_r)
            yy_r = false;
          else {
            yyline++;
          }
          break;
        default:
          yy_r = false;
        }
      }

      if (yy_r) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean yy_peek;
        if (yy_markedPos_l < yy_endRead_l)
          yy_peek = yy_buffer_l[yy_markedPos_l] == '\n';
        else if (yy_atEOF)
          yy_peek = false;
        else {
          boolean eof = yy_refill();
          yy_markedPos_l = yy_markedPos;
          yy_buffer_l = yy_buffer;
          if (eof) 
            yy_peek = false;
          else 
            yy_peek = yy_buffer_l[yy_markedPos_l] == '\n';
        }
        if (yy_peek) yyline--;
      }
      yy_action = -1;

      yy_startRead_l = yy_currentPos_l = yy_currentPos = 
                       yy_startRead = yy_markedPos_l;

      yy_state = yy_lexical_state;


      yy_forAction: {
        while (true) {

          if (yy_currentPos_l < yy_endRead_l)
            yy_input = yy_buffer_l[yy_currentPos_l++];
          else if (yy_atEOF) {
            yy_input = YYEOF;
            break yy_forAction;
          }
          else {
            // store back cached positions
            yy_currentPos  = yy_currentPos_l;
            yy_markedPos   = yy_markedPos_l;
            boolean eof = yy_refill();
            // get translated positions and possibly new buffer
            yy_currentPos_l  = yy_currentPos;
            yy_markedPos_l   = yy_markedPos;
            yy_buffer_l      = yy_buffer;
            yy_endRead_l     = yy_endRead;
            if (eof) {
              yy_input = YYEOF;
              break yy_forAction;
            }
            else {
              yy_input = yy_buffer_l[yy_currentPos_l++];
            }
          }
          int yy_next = yytrans_l[ yy_rowMap_l[yy_state] + yycmap_l[yy_input] ];
          if (yy_next == -1) break yy_forAction;
          yy_state = yy_next;

          int yy_attributes = yy_attr_l[yy_state];
          if ( (yy_attributes & 1) == 1 ) {
            yy_action = yy_state; 
            yy_markedPos_l = yy_currentPos_l; 
            if ( (yy_attributes & 8) == 8 ) break yy_forAction;
          }

        }
      }

      // store back cached position
      yy_markedPos = yy_markedPos_l;

      switch (yy_action) {

        case 29: 
          { lexeme=yytext(); return etiqueta; }
        case 246: break;
        case 28: 
        case 32: 
        case 36: 
          { lexeme=yytext(); return registro; }
        case 247: break;
        case 17: 
        case 20: 
        case 21: 
        case 59: 
        case 60: 
        case 119: 
          { lexeme=yytext(); return num_dec; }
        case 248: break;
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 26: 
        case 27: 
        case 30: 
        case 31: 
        case 33: 
        case 34: 
        case 38: 
        case 39: 
        case 40: 
        case 41: 
        case 42: 
        case 43: 
        case 44: 
        case 45: 
        case 46: 
        case 47: 
        case 48: 
        case 49: 
        case 50: 
        case 51: 
        case 52: 
        case 57: 
        case 76: 
        case 77: 
        case 78: 
        case 79: 
        case 80: 
        case 81: 
        case 82: 
        case 83: 
        case 84: 
        case 85: 
        case 86: 
        case 87: 
        case 88: 
        case 89: 
        case 91: 
        case 92: 
        case 93: 
        case 105: 
        case 106: 
        case 107: 
        case 108: 
        case 109: 
        case 110: 
        case 111: 
        case 114: 
        case 115: 
        case 117: 
        case 118: 
        case 128: 
        case 129: 
        case 130: 
        case 131: 
        case 141: 
        case 156: 
        case 157: 
        case 183: 
          { lexeme=yytext(); return simbolo; }
        case 249: break;
        case 58: 
        case 61: 
          { lexeme=yytext(); return num_bin; }
        case 250: break;
        case 55: 
          {  lexeme=yytext(); return num_dec; }
        case 251: break;
        case 188: 
          { lexeme=yytext(); return pseudo_const_bin; }
        case 252: break;
        case 161: 
          { lexeme=yytext(); return pseudo_const_num; }
        case 253: break;
        case 182: 
        case 237: 
          { lexeme=yytext(); return stack_segment; }
        case 254: break;
        case 199: 
          { lexeme=yytext(); return pseudo_const_carac; }
        case 255: break;
        case 198: 
          { lexeme=yytext(); return pseudo_const_hexa; }
        case 256: break;
        case 168: 
          { lexeme=yytext(); return pseudo_const_inco; }
        case 257: break;
        case 95: 
          { 
    System.out.println("proyectoensambladores3.FramePrincipal.Analisis()");
    lexeme=yytext(); 
    return num_exa;
 }
        case 258: break;
        case 236: 
          { lexeme=yytext(); return model_small; }
        case 259: break;
        case 155: 
        case 233: 
          { lexeme=yytext(); return data_segment; }
        case 260: break;
        case 154: 
        case 232: 
          { lexeme=yytext(); return code_segment; }
        case 261: break;
        case 126: 
          { lexeme=yytext(); return acc_memoria; }
        case 262: break;
        case 124: 
          { lexeme=yytext(); return const_carac; }
        case 263: break;
        case 121: 
        case 143: 
          { lexeme=yytext(); return const_carac; }
        case 264: break;
        case 53: 
          { lexeme=yytext(); return instruccion; }
        case 265: break;
        case 63: 
        case 97: 
          { lexeme=yytext(); return const_carac; }
        case 266: break;
        case 67: 
        case 101: 
          { lexeme=yytext(); return const_carac; }
        case 267: break;
        case 25: 
          { /*Ignore*/ }
        case 268: break;
        case 2: 
          { /*Ignore*/ }
        case 269: break;
        case 201: 
          { lexeme=yytext(); return wptr; }
        case 270: break;
        case 195: 
          { lexeme=yytext(); return bptr; }
        case 271: break;
        case 90: 
          { lexeme=yytext(); return equ; }
        case 272: break;
        case 116: 
          { lexeme=yytext(); return ends; }
        case 273: break;
        case 35: 
          { lexeme=yytext(); return db; }
        case 274: break;
        case 37: 
          { lexeme=yytext(); return dw; }
        case 275: break;
        case 1: 
        case 18: 
        case 19: 
        case 22: 
        case 23: 
        case 24: 
          { return ERROR; }
        case 276: break;
        default: 
          if (yy_input == YYEOF && yy_startRead == yy_currentPos) {
            yy_atEOF = true;
            return null;
          } 
          else {
            yy_ScanError(YY_NO_MATCH);
          }
      }
    }
  }


}
