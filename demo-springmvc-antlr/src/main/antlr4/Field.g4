/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar Field;

@header{
package com.lance.antlr;
}

field:
    name=Name NL
    (points NL)+
    (burial NL)+
    EOF;

points: treasure=Name WS 'scores' WS value=Int WS 'points';
burial: treasure=Name WS 'is' WS 'buried' WS 'at' WS at=location ;
location: x=Int ',' y=Int;

Name: '"' ('A'..'Z' | 'a'..'z' | ' ')+ '"' ;
Int: ('0'..'9')+;

WS: (' ' | '\t')+;
NL:  '\r'? '\n';