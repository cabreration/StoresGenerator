package FGrammar;

import java_cup.runtime.*;
import java.util.ArrayList;

%%

%{
    //public ArrayList<ErrorC> errores = new ArrayList<>();
%}

%public
%class LexicoSG
%cupsym SimbolosSG
%cup
%char
%column
%full
%ignorecase
%line
%unicode

digito = [0-9]
numero = {digito}+("." {digito}+)?
cadena = "\"" ~"\""
letra = [a-zA-ZñÑ]
identificador = ({letra}|"_")({letra}|{digito}|"_")*

%%

<YYINITIAL> "$request$"                      {return new Symbol(SimbolosSG.peticion_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$request-$"                     {return new Symbol(SimbolosSG.peticion_F, yycolumn, yyline, yytext());}
<YYINITIAL> "$InicioUsuario$"                {return new Symbol(SimbolosSG.inicioUsuario_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$InicioUsuario-$"               {return new Symbol(SimbolosSG.inicioUsuario_F, yycolumn, yyline, yytext());}
<YYINITIAL> "$id$"                           {return new Symbol(SimbolosSG.id_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$id-$"                          {return new Symbol(SimbolosSG.id_F, yycolumn, yyline, yytext());}
<YYINITIAL> "id"                             {return new Symbol(SimbolosSG.id, yycolumn, yyline, yytext());}
<YYINITIAL> "$password$"                     {return new Symbol(SimbolosSG.password_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$password-$"                    {return new Symbol(SimbolosSG.password_F, yycolumn, yyline, yytext());}
<YYINITIAL> "password"                       {return new Symbol(SimbolosSG.password, yycolumn, yyline, yytext());}
<YYINITIAL> "$"                              {return new Symbol(SimbolosSG,dalla, yycolumn, yyline, yytext());}
//<YYINITIAL> "reply"                          {return new Symbol(SimbolosSG.respuesta, yycolumn, yyline, yytext());}
//<YYINITIAL> "usuario"                        {return new Symbol(SimbolosSG.usuario, yycolumn, yyline, yytext());}
//<YYINITIAL> "access"                         {return new Symbol(SimbolosSG.acceso, yycolumn, yyline, yytext());}
<YYINITIAL> "true"                           {return new Symbol(SimbolosSG.verdadero, yycolumn, yyline, yytext());}
<YYINITIAL> "false"                          {return new Symbol(SimbolosSG.falso, yycolumn, yyline, yytext());}
<YYINITIAL> "$crearUsuario$"                 {return new Symbol(SimbolosSG.crearUsuario_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$crearUsuario-$"                {return new Symbol(SimbolosSG.crearUsuario_F, yycolumn, yyline, yytext());}
<YYINITIAL> "$nombre$"                       {return new Symbol(SimbolosSG.nombre_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$nombre-$"                      {return new Symbol(SimbolosSG.nombre_F, yycolumn, yyline, yytext());}
<YYINITIAL> "nombre"                         {return new Symbol(SimbolosSG.nombre, yycolumn, yyline, yytext());}
<YYINITIAL> "$apellido$"                     {return new Symbol(SimbolosSG.apellido_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$apellido-$"                    {return new Symbol(SimbolosSG.apellido_F, yycolumn, yyline, yytext());}
<YYINITIAL> "apellido"                       {return new Symbol(SimbolosSG.apellido, yycolumn, yyline, yytext());}
<YYINITIAL> "$telefono$"                     {return new Symbol(SimbolosSG.telefono_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$telefono-$"                    {return new Symbol(SimbolosSG.telefono_F, yycolumn, yyline, yytext());}
<YYINITIAL> "telefono"                       {return new Symbol(SimbolosSg.telfono, yycolumn, yyline, yytext());}
<YYINITIAL> "$email$"                        {return new Symbol(SimbolosSG.email_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$email-$"                       {return new Symbol(SimbolosSG.email_F, yycolumn, yyline, yytext());}
<YYINITIAL> "email"                          {return new Symbol(SimbolosSG.email, yycolumn, yyline, yytext());}
<YYINITIAL> "$direccion$"                    {return new Symbol(SimbolosSG.direccion_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$direccion-$"                   {return new Symbol(SimbolosSG.direccion_F, yycolumn, yyline, yytext());}
<YYINITIAL> "direccion"                      {return new Symbol(SimbolosSG.direccion, yycolumn, yyline, yytext());}
<YYINITIAL> "="                              {return new Symbol(SimbolosSG.igual, yycolumn, yyline, yytext());}
<YYINITIAL> "tienda"                         {return new Symbol(SimbolosSG.tienda, yycolumn, yyline, yytext());}
<YYINITIAL> "$tienda-$"                      {return new Symbol(SimbolosSG.tienda_F, yycolumn, yyline, yytext());}
<YYINITIAL> "tipo"                           {return new Symbol(SimbolosSG.tipo, yycolumn, yyline, yytext());}
<YYINITIAL> "$codigo$"                       {return new Symbol(SimbolosSG.codigo_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$codigo-$"                      {return new Symbol(SimbolosSG.codigo_F, yycolumn, yyline, yytext());}
<YYINITIAL> "$propietario$"                  {return new Symbol(SimbolosSG.propietario_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$propietario-$"                 {return new Symbol(SimbolosSG.propietario_F, yycolumn, yyline, yytext());}
<YYINITIAL> "$img$"                          {return new Symbol(SimbolosSG.imagen_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$img-$"                         {return new Symbol(SimbolosSG.imagen_F, yycolumn, yyline, yytext());}
<YYINITIAL> "modificar"                      {return new Symbol(SimbolosSG.modificar, yycolumn, yyline, yytext());}
<YYINITIAL> "codigo"                         {return new Symbol(SimbolosSG.codigo, yycolumn, yyline, yytext());}
<YYINITIAL> "propietario"                    {return new Symbol(SimbolosSG.propietario, yycolumn, yyline, yytext());}
<YYINITIAL> "img"                            {return new Symbol(SimbolosSG.img, yycolumn, yyline, yytext());}
<YYINITIAL> "eliminar"                       {return new Symbol(SimbolosSG.eliminar, yycolumn, yyline, yytext());}
<YYINITIAL> "producto"                       {return new Symbol(SimbolosSG.producto, yycolumn, yyline, yytext());}
<YYINITIAL> "cantidad"                       {return new Symbol(SimbolosSG.cantidad, yycolumn, yyline, yytext());}
<YYINITIAL> "marca"                          {return new Symbol(SimbolosSG.marca, yycolumn, yyline, yytext());}
<YYINITIAL> "color"                          {return new Symbol(SimbolosSG.color, yycolumn, yyline, yytext());}
<YYINITIAL> "tamaño"                         {return new Symbol(SimbolosSG.tamanio, yycolumn, yyline, yytext());}
<YYINITIAL> "sucursal"                       {return new Symbol(SimbolosSG.sucursal, yycolumn, yyline, yytext());}
<YYINITIAL> "$producto-$"                    {return new Symbol(SimbolosSG.producto_F, yycolumn, yyline, yytext());}
<YYINITIAL> "$cantidad$"                     {return new Symbol(SimbolosSG.cantidad_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$cantidad-$"                    {return new Symbol(SimbolosSG.cantidad_F, yycolumn, yyline, yytext());}
<YYINITIAL> "$marca$"                        {return new Symbol(SimbolosSG.marca_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$marca-$"                       {return new Symbol(SimbolosSG.marca_F, yycolumn, yyline, yytext());}
<YYINITIAL> "$tamaño$"                       {return new Symbol(SimbolosSG.tamanio_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$tamaño-$"                      {return new Symbol(SimbolosSG.tamanio_F, yycolumn, yyline, yytext());}
<YYINITIAL> "$sucursal$"                     {return new Symbol(SimbolosSG.sucursal_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$sucursal-$"                    {return new Symbol(SimbolosSG.sucursal_F, yycolumn, yyline, yytext());}
<YYINITIAL> "%%"                             {return new Symbol(SimbolosSG.and, yycolumn, yyline, yytext());}
<YYINITIAL> "##"                             {return new Symbol(SimbolosSG.or, yycolumn, yyline, yytext());}
<YYINITIAL> "N"                              {return new Symbol(SimbolosSG.not, yycolumn, yyline, yytext());}
<YYINITIAL> "$query$"                        {return new Symbol(SimbolosSG.consulta_I, yycolumn, yyline, yytext());}
<YYINITIAL> "$query-$"                       {return new Symbol(SimbolosSG.consulta_F, yycolumn, yyline, yytext());}
<YYINITIAL> "vacio"                          {return new Symbol(SimbolosSG.vacio, yycolumn, yyline, yytext());}
<YYINITIAL> "extraer"                        {return new Symbol(SimbolosSG.extraer, yycolumn, yyline, yytext());}
<YYINITIAL> "de"                             {return new Symbol(SimbolosSG.de, yycolumn, yyline, yytext());}
<YYINITIAL> "donde"                          {return new Symbol(SimbolosSG.donde, yycolumn, yyline, yytext());}
<YYINITIAL> "=="                             {return new Symbol(SimbolosSG.igualIgual, yycolumn, yyline, yytext());}
<YYINITIAL> ";"                              {return new Symbol(SimbolosSG.puntoYcoma, yycolumn, yyline, yytext());}
<YYINITIAL> "("                              {return new Symbol(SimbolosSG.parentesisA, yycolumn, yyline, yytext());}
<YYINITIAL> ")"                              {return new Symbol(SimbolosSG.parentesisC, yycolumn, yyline, yytext());}
<YYINITIAL> "{"                              {return new Symbol(SimbolosSG.llaveA, yycolumn, yyline, yytext());} 
<YYINITIAL> "}"                              {return new Symbol(SimbolosSG.llaveC, yycolumn, yyline, yytext());}
<YYINITIAL> "+"                              {return new Symbol(SimbolosSG.mas, yycolumn, yyline, yytext());}
<YYINITIAL> "-"                              {return new Symbol(SimbolosSG.menos, yycolumn, yyline, yytext());}
<YYINITIAL> "*"                              {return new Symbol(SimbolosSG.por, yycolumn, yyline, yytext());}
<YYINITIAL> "/"                              {return new Symbol(SimbolosSG.sobre, yycolumn, yyline, yytext());}
<YYINITIAL> "Rq"                             {return new Symbol(SimbolosSG.raizCuadrada, yycolumn, yyline, yytext());}
<YYINITIAL> "Ptn"                            {return new Symbol(SimbolosSG.elevadoA, yycolumn, yyline, yytext());}
//<YYINITIAL> "error"                          {return new Symbol(SimbolosSG.error, yycolumn, yyline, yytext());}
//<YYINITIAL> "descripcion"                    {return new Symbol(SimbolosSG.descripcion, yycolumn, yyline, yytext());}
<YYINITIAL> {numero}                         {return new Symbol(SimbolosSG.numero, yycolumn, yyline, yytext());}
<YYINITIAL> {cadena}                         {return new Symbol(SimbolosSG.cadena, yycolumn, yyline, yytext());}
//<YYINITIAL> "lista"                          {return new Symbol(SimbolosSG.lista, yycolumn, yyline, yytext());}
<YYINITIAL> "get"                            {return new Symbol(SimbolosSG.obtener, yycolumn, yyline, yytext();)}


<YYINITIAL> [ \t\r\f\n]                      {}

<YYINITIAL> .                                {/*errores.add(new ErrorC("Error Lexico", yytext(), yyline, yycolumn, "No pertenece al lenguaje"));*/}


