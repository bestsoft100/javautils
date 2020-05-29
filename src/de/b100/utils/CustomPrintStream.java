package de.b100.utils;

import java.io.PrintStream;

public abstract class CustomPrintStream extends PrintStream{
	
	protected PrintStream old;
	
	public CustomPrintStream(PrintStream printStream) {
		super(printStream);
		this.old = printStream;
	}
	
	public void println(String x) {
		write(x);
	}
	
	public void println(Object x) {
		write(x.toString());
	}
	
	public void println(boolean x) {
		write(""+x);
	}
	
	public void println(char x) {
		write(""+x);
	}
	
	public void println(char[] x) {
		write(new String(x));
	}
	
	public void println(double x) {
		write(""+x);
	}
	
	public void println(float x) {
		write(""+x);
	}
	
	public void println(int x) {
		write(""+x);
	}
	
	public void println(long x) {
		write(""+x);
	}
	
	protected abstract void write(String string);
	
}
