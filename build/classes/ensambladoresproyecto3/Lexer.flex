package ensambladoresproyecto3;
import static ensambladoresproyecto3.Tokens.*;
%%
%class Lexer
%type Tokens
%line
%ignorecase
com = ";"
registro = "AX"|"BX"|"CX"|"DX"|"AH"|"AL"|"BL"|"BH"|"CH"|"CL"|"DH"|"DL"|"DI"|"SI"|"BP"|"SP"|"DS"|"ES"|"SS"|"CS"
instruccion = "STD"|"AAD"|"CLD"|"CWD"|"IRET"|"MOVSW"|"DIV"|"IMUL"|"POP"|"IDIV"|"SHL"|"XCHG"|"ADD"|"LDS"|"JNS"|"JS"|"LOOPNE"|"JAE"|"JCXZ"|"JL"
L= [a-zA-Z0-9_\$\.]+
D= [0-9]+
E= [\.\$]

num_dec = ("(-"{D}+")")|{D}+
num_exa = 0+[0-9a-fA-F]+H
num_bin = [0-1]+B

C=";"
ParAbre = "("
ParCierra = ")"
comilla_doble = "\""
comilla_simple = "\'"
corchete_abre = "["
corchete_cierra = "]"
dos_puntos = ":"

suma = "+"
byte_ptr = "byte ptr"
word_ptr = "word ptr"

db = "db"|"DB"
dw = "dw"|"DW"

bptr = "BYTE PTR"
wptr = "WORD PTR"
declarar = "???"
declarar2 = \'???'
comsimples = \'
Dup = "dup"|"DUP"

menos = "-"
numeros = ("(-"{D}+")")|{D}+

equ = "equ"

c = .*

espacio=[ ,\t,\r,\n]+
esp= " "

%{
    public String lexeme;
%}
%%

{espacio} {/*Ignore*/}
";".* {/*Ignore*/}


{bptr} {lexeme=yytext(); return bptr;}
{wptr} {lexeme=yytext(); return wptr;}

/*REGISTROS*/
{registro} {lexeme=yytext(); return registro;}

/*INSTRUCCIONES*/
{instruccion} {lexeme=yytext(); return instruccion;}

/*COSNTANTES NUMERICAS*/
("(-"{D}+")")|{D}+ {lexeme=yytext(); return num_dec;}
{num_exa} {
    System.out.println("proyectoensambladores3.FramePrincipal.Analisis()");
    lexeme=yytext(); 
    return num_exa;
}
{num_bin} {lexeme=yytext(); return num_bin;}

/*CONSTANTES CARACTER*/
{comilla_doble}{c}{comilla_doble} {lexeme=yytext(); return const_carac;} 
{comilla_doble}{espacio}{c}{espacio}{comilla_doble} {lexeme=yytext(); return const_carac;} 
{comilla_simple}{c}{comilla_simple} {lexeme=yytext(); return const_carac;} 
{comilla_simple}{espacio}{c}{espacio}{comilla_simple} {lexeme=yytext(); return const_carac;}


"code segment"|".code segment"|".code" {lexeme=yytext(); return code_segment;}
"data segment"|".data segment"|".data" {lexeme=yytext(); return data_segment;}
"stack segment"|".stack segment"|".stack" {lexeme=yytext(); return stack_segment;} 
".model small" {lexeme=yytext(); return model_small;}

/*DB Y DW*/
{db} {lexeme=yytext(); return db;}
{dw} {lexeme=yytext(); return dw;}

{equ} {lexeme=yytext(); return equ;}

{menos}{numeros} { lexeme=yytext(); return num_dec;}

/*DUP SIN DECLARAR*/
{Dup}{ParAbre}{declarar}{ParCierra} {lexeme=yytext(); return pseudo_const_inco;}
{Dup}{ParAbre}{declarar2}{ParCierra} {lexeme=yytext(); return pseudo_const_inco;}
{Dup}{ParAbre}{comsimples}{esp}{comsimples}{ParCierra} {lexeme=yytext(); return pseudo_const_inco;}

/*DUP ENTEROS*/
{Dup}{ParAbre}{D}{ParCierra} {lexeme=yytext(); return pseudo_const_num;}
{Dup}{esp}{ParAbre}{D}{ParCierra} {lexeme=yytext(); return pseudo_const_num;}

/*DUP HEXADECIMAL*/
{Dup}{ParAbre}{num_exa}{ParCierra} {lexeme=yytext(); return pseudo_const_hexa;}
{Dup}{esp}{ParAbre}{num_exa}{ParCierra} {lexeme=yytext(); return pseudo_const_hexa;}

/*DUP CARACTER*/
{Dup}{ParAbre}{comilla_simple}{L}{comilla_simple}{ParCierra} {lexeme=yytext(); return pseudo_const_carac;}
{Dup}{esp}{ParAbre}{comilla_simple}{L}{comilla_simple}{ParCierra} {lexeme=yytext(); return pseudo_const_carac;}

/*DUP BINARIO*/
{Dup}{ParAbre}{num_bin}{ParCierra} {lexeme=yytext(); return pseudo_const_bin;}
{Dup}{esp}{ParAbre}{num_bin}{ParCierra} {lexeme=yytext(); return pseudo_const_bin;}

/*ACCESO A MEMORIA*/
{corchete_abre}{registro}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}

{corchete_abre}{registro}{suma}{registro}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}

{corchete_abre}{registro}{suma}{num_dec}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}
{corchete_abre}{registro}{suma}{num_exa}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}
{corchete_abre}{registro}{suma}{num_bin}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}

{corchete_abre}{registro}{suma}{registro}{suma}{num_dec}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}
{corchete_abre}{registro}{suma}{registro}{suma}{num_exa}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}
{corchete_abre}{registro}{suma}{registro}{suma}{num_bin}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}

{word_ptr}{corchete_abre}{registro}{suma}{registro}{suma}{num_dec}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}
{word_ptr}{esp}{corchete_abre}{registro}{suma}{registro}{suma}{num_dec}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}
{word_ptr}{corchete_abre}{registro}{suma}{registro}{suma}{num_exa}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}
{word_ptr}{esp}{corchete_abre}{registro}{suma}{registro}{suma}{num_exa}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}
{word_ptr}{corchete_abre}{registro}{suma}{registro}{suma}{num_bin}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}
{word_ptr}{esp}{corchete_abre}{registro}{suma}{registro}{suma}{num_bin}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}

{word_ptr}{corchete_abre}{registro}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}
{word_ptr}{esp}{corchete_abre}{registro}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}
{byte_ptr}{corchete_abre}{registro}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}
{byte_ptr}{esp}{corchete_abre}{registro}{corchete_cierra} {lexeme=yytext(); return acc_memoria;}



/*Pseudoinstruccion*/
"ends" {lexeme=yytext(); return ends;}


/*ETIQUETA*/
{L}({L}|{D})*{dos_puntos} {lexeme=yytext(); return etiqueta;}

{L}({L}|{D})* {lexeme=yytext(); return simbolo;}
 . {return ERROR;}

