package com.lance.antlr;

import java.io.IOException;
import java.io.StringReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.TokenStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.lance.antlr.calc.ExprLexer;
import com.lance.antlr.calc.ExprParser;

public class CalucateTest {
	Logger logger = LogManager.getLogger(getClass());

	@Test
	public void add() {
		String addString = "x = 3.14 ^ 7 ^ (cos (y))";
		try {
			CharStream inputCharStream = new ANTLRInputStream(new StringReader(addString));
			TokenSource tokenSource = new ExprLexer(inputCharStream);
			TokenStream tokenStream = new CommonTokenStream(tokenSource);
			ExprParser parser = new ExprParser(tokenStream);
			parser.addErrorListener(new ConsoleErrorListener());
			
			//EquationContext context = parser.equation();
			logger.info("add: {}", "");
		} catch (IOException e) {
			e.printStackTrace();
		}
        //TokenSource tokenSource = new Exprlex(inputCharStream);
	}
}
