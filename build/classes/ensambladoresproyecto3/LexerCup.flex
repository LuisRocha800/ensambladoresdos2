package ensambladoresproyecto3;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
%ignorecase

com = ";"

L= [a-zA-Z0-9\.\$]+
D= [0-9]+
E= [\.\$]

num_exa = 0+[0-9a-fA-F]+H
num_bin = 0+[0-1]+B

fin = "ends"

C=";"
ParAbre = "("
ParCierra = ")"
par="( )"
comilla_doble = "\""
comilla_simple = "\'"
corchete_abre = "["
corchete_cierra = "]"

db = "db"|"DB"
dw = "dw"|"DW"

Dup = "dup"|"DUP"
Data_Segment= ".Data Segment"
code_segment = "code segment"|".Code Segment"
stack_segment = "stack segment"|".Stack Segment"
data_segment = "data segment"|"Data Segment"
espacio=[ ,\t,\r,\n]+
falta="(???)"
dup_inco = "dup(???)"

%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }

    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

{espacio} {/*Ignore*/}
";".* {/*Ignore*/}


{Data_Segment} {return new Symbol(sym.Pseudoinstruccion, yychar, yyline, yytext());}
{code_segment} {return new Symbol(sym.Pseudoinstruccion, yychar, yyline, yytext());}
{data_segment} {return new Symbol(sym.Pseudoinstruccion, yychar, yyline, yytext());}
{stack_segment} {return new Symbol(sym.Pseudoinstruccion, yychar, yyline, yytext());}

/*DB Y DW*/
{db} {return new Symbol(sym.db, yychar, yyline, yytext());}
{dw} {return new Symbol(sym.dw, yychar, yyline, yytext());}




/*DUP ENTEROS*/
{Dup}{ParAbre}{D}{ParCierra} {return new Symbol(sym.Pseudo_const_num, yychar, yyline, yytext());}


/*DUP HEXADECIMAL*/
{Dup}{ParAbre}{num_exa}{ParCierra} {return new Symbol(sym.Pseudo_const_hexa, yychar, yyline, yytext());}

/*DUP CARACTER*/
{Dup}{ParAbre}{comilla_doble}{L}{comilla_doble}{ParCierra} {return new Symbol(sym.Pseudo_const_carac, yychar, yyline, yytext());}
{Dup}{ParAbre}{comilla_simple}{L}{comilla_simple}{ParCierra} {return new Symbol(sym.Pseudo_const_carac, yychar, yyline, yytext());}

/*DUP BINARIO*/
{Dup}{ParAbre}{num_bin}{ParCierra} {return new Symbol(sym.Pseudo_const_bin, yychar, yyline, yytext());}

/*Pseudoinstruccion*/
{fin} {return new Symbol(sym.Pseudoinstruccion, yychar, yyline, yytext());}

{L}({L}|{D}|{E})* {return new Symbol(sym.Simbolo, yychar, yyline, yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}

/*COSNTANTES NUMERICAS*/
{num_exa} {return new Symbol(sym.Num_exa, yychar, yyline, yytext());}
{num_bin} {return new Symbol(sym.Num_bin, yychar, yyline, yytext());}

/*CONSTANTES CARACTER*/
{comilla_doble}{L}{comilla_doble} {return new Symbol(sym.Const_carac, yychar, yyline, yytext());} 
{comilla_doble}{espacio}{L}{espacio}{comilla_doble} {return new Symbol(sym.Const_carac, yychar, yyline, yytext());} 
