/* The following code was generated by JFlex 1.3.5 on 26/6/22 12:26 a. m. */

package ensambladoresproyecto3;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.3.5
 * on 26/6/22 12:26 a. m. from the specification file
 * <tt>file:/home/juan/NetBeansProjects/Ensamblador/src/codigo/LexerCup.flex</tt>
 */
class LexerCup implements java_cup.runtime.Scanner {

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
     0,  0,  0,  0,  0,  0,  0,  0,  0, 29, 30,  0,  0, 29,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
    15,  0, 16,  0,  2,  0,  0, 17, 13, 14,  0,  0, 29, 31, 21,  0, 
     4,  7,  3,  3,  3,  3,  3,  3,  3,  3,  0,  1,  0,  0,  0,  0, 
     0, 22,  8, 26, 11,  9,  5, 24,  6,  2,  2, 28,  2, 25, 10, 27, 
    20,  2,  2, 12, 23, 19,  2, 18,  2,  2,  2,  0,  0,  0,  0,  0, 
     0, 22,  8, 26, 11,  9,  5, 24,  6,  2,  2, 28,  2, 25, 10, 27, 
    20,  2,  2, 12, 23, 19,  2, 18,  2,  2,  2,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates a state to a row index in the transition table
   */
  final private static int yy_rowMap [] = { 
        0,    32,    64,    96,   128,   160,   192,   224,   256,   288, 
      320,   352,   384,    96,    96,   416,   448,   480,   512,   544, 
      576,   608,   640,   672,   704,   736,   768,   800,    32,   832, 
      864,    96,   896,   928,   960,    32,   992,  1024,  1056,  1088, 
     1120,  1152,    32,  1184,  1216,  1248,  1280,  1312,  1344,  1376, 
     1408,  1440,  1472,    32,    32,    32,  1504,  1536,  1568,  1600, 
       32
  };

  /** 
   * The packed transition table of the DFA (part 0)
   */
  final private static String yy_packed0 = 
    "\1\2\1\3\7\4\1\5\1\4\1\6\1\7\1\10"+
    "\1\2\1\11\1\12\1\2\3\4\1\13\4\4\1\14"+
    "\2\4\2\11\1\2\40\0\36\3\1\0\1\3\2\0"+
    "\13\4\5\0\13\4\5\0\10\4\1\15\2\4\5\0"+
    "\13\4\5\0\6\4\1\16\4\4\5\0\1\17\1\20"+
    "\2\4\1\21\6\4\5\0\13\4\5\0\5\4\1\22"+
    "\5\4\42\0\1\23\17\0\1\11\15\0\2\11\3\0"+
    "\13\24\2\0\1\25\2\0\13\24\2\25\3\0\11\4"+
    "\1\26\1\7\5\0\10\4\1\14\2\4\5\0\13\4"+
    "\5\0\11\4\1\27\1\4\5\0\11\4\1\30\1\4"+
    "\5\0\13\4\5\0\13\4\5\0\2\4\1\31\10\4"+
    "\5\0\13\4\5\0\5\4\1\32\5\4\5\0\13\4"+
    "\5\0\4\4\1\33\6\4\6\0\2\34\2\0\1\34"+
    "\32\0\13\24\3\0\1\35\1\0\13\24\5\0\13\36"+
    "\2\0\1\25\2\0\13\36\2\25\3\0\13\4\5\0"+
    "\4\4\1\21\6\4\5\0\11\4\1\37\1\4\5\0"+
    "\13\4\5\0\12\4\1\40\5\0\13\4\5\0\13\4"+
    "\1\41\4\0\13\4\5\0\13\4\5\0\4\4\1\42"+
    "\6\4\5\0\13\4\5\0\10\4\1\43\2\4\6\0"+
    "\2\34\2\0\1\34\6\0\1\44\23\0\13\36\2\0"+
    "\1\45\2\0\13\36\2\45\3\0\7\4\1\42\3\4"+
    "\5\0\13\4\6\0\1\46\1\47\2\0\1\46\10\0"+
    "\1\50\1\51\20\0\13\4\2\0\1\52\2\0\13\4"+
    "\5\0\13\4\5\0\12\4\1\42\22\0\1\45\1\35"+
    "\14\0\2\45\4\0\2\46\2\0\1\46\6\0\1\53"+
    "\24\0\1\54\1\55\1\56\1\0\1\55\2\56\1\0"+
    "\1\56\2\0\1\53\7\0\1\56\3\0\1\56\7\0"+
    "\13\57\5\0\13\57\5\0\13\60\5\0\13\60\17\0"+
    "\1\61\26\0\2\54\1\56\1\62\1\54\2\56\1\0"+
    "\1\56\2\0\1\53\7\0\1\56\3\0\1\56\10\0"+
    "\1\54\1\55\1\56\1\62\1\55\1\63\1\56\1\0"+
    "\1\56\2\0\1\53\7\0\1\56\3\0\1\56\10\0"+
    "\3\56\1\62\3\56\1\0\1\56\12\0\1\56\3\0"+
    "\1\56\7\0\13\57\3\0\1\64\1\0\13\57\5\0"+
    "\13\60\4\0\1\64\13\60\14\0\1\65\44\0\1\66"+
    "\24\0\3\56\1\62\3\56\1\0\1\56\2\0\1\67"+
    "\7\0\1\56\3\0\1\56\23\0\1\70\51\0\1\71"+
    "\40\0\1\72\17\0\1\73\40\0\1\74\54\0\1\75"+
    "\10\0";

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
     1,  1,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  9,  0,  1,  1, 
     0,  1,  1,  9,  0,  0,  0,  0,  0,  0,  9,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  9,  9,  9,  0,  0,  0,  0,  9
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

  /** denotes if the user-EOF-code has already been executed */
  private boolean yy_eof_done;

  /* user code: */
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }

    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  LexerCup(java.io.Reader in) {
    this.yy_reader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  LexerCup(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the split, compressed DFA transition table.
   *
   * @return the unpacked transition table
   */
  private static int [] yy_unpack() {
    int [] trans = new int[1632];
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
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void yy_do_eof() throws java.io.IOException {
    if (!yy_eof_done) {
      yy_eof_done = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
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

      yychar+= yy_markedPos_l-yy_startRead;

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

        case 28: 
          { return new Symbol(sym.Const_carac, yychar, yyline, yytext()); }
        case 62: break;
        case 35: 
          { return new Symbol(sym.Numero, yychar, yyline, yytext()); }
        case 63: break;
        case 1: 
        case 7: 
        case 9: 
          { return new Symbol(sym.ERROR, yychar, yyline, yytext()); }
        case 64: break;
        case 2: 
          { /*Ignore*/ }
        case 65: break;
        case 8: 
          { /*Ignore*/ }
        case 66: break;
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 10: 
        case 11: 
        case 12: 
        case 15: 
        case 16: 
        case 17: 
        case 21: 
        case 22: 
        case 23: 
        case 24: 
        case 25: 
        case 26: 
        case 30: 
        case 33: 
        case 34: 
          { return new Symbol(sym.Simbolo, yychar, yyline, yytext()); }
        case 67: break;
        case 13: 
          { return new Symbol(sym.db, yychar, yyline, yytext()); }
        case 68: break;
        case 14: 
          { return new Symbol(sym.dw, yychar, yyline, yytext()); }
        case 69: break;
        case 55: 
          { return new Symbol(sym.Pseudo_const_carac, yychar, yyline, yytext()); }
        case 70: break;
        case 60: 
          { return new Symbol(sym.Pseudoinstruccion, yychar, yyline, yytext()); }
        case 71: break;
        case 31: 
          { return new Symbol(sym.Pseudoinstruccion, yychar, yyline, yytext()); }
        case 72: break;
        case 54: 
          { return new Symbol(sym.Pseudo_const_bin, yychar, yyline, yytext()); }
        case 73: break;
        case 53: 
          { return new Symbol(sym.Pseudo_const_hexa, yychar, yyline, yytext()); }
        case 74: break;
        case 42: 
          { return new Symbol(sym.Pseudo_const_num, yychar, yyline, yytext()); }
        case 75: break;
        default: 
          if (yy_input == YYEOF && yy_startRead == yy_currentPos) {
            yy_atEOF = true;
            yy_do_eof();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            yy_ScanError(YY_NO_MATCH);
          }
      }
    }
  }


}
