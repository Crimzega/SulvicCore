package com.sulvic.core.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;

public class MezidaLogger{
	
	private Logger logger;
	
	public MezidaLogger(Class<?> aClass){ logger = LogManager.getLogger(aClass.getSimpleName()); }
	
	public MezidaLogger(Object obj){ logger = LogManager.getLogger(obj); }
	
	public void catching(Throwable thrown){ logger.catching(thrown); }
	
	public void catching(Level lvl, Throwable thrown){ logger.catching(lvl, thrown); }
	
	public void debug(Marker mark, Object msg){ logger.debug(mark, msg); }
	
	public void debug(Marker mark, Object msg, Throwable thrown){ logger.debug(mark, msg, thrown); }
	
	public void debug(Marker mark, String msg, Object... args){ logger.debug(mark, msg, args); }
	
	public void debug(Object msg){ logger.debug(msg); }
	
	public void debug(Object msg, Throwable thrown){ logger.debug(msg, thrown); }
	
	public void debug(String msg, Object... args){ logger.debug(msg, args); }
	
	public void error(Marker mark, Object msg){ logger.error(mark, msg); }
	
	public void error(Marker mark, Object msg, Throwable thrown){ logger.error(mark, msg, thrown); }
	
	public void error(Marker mark, String msg, Object... args){ logger.error(mark, msg, args); }
	
	public void error(Object msg){ logger.error(msg); }
	
	public void error(Object msg, Throwable thrown){ logger.error(msg, thrown); }
	
	public void error(String msg, Object... args){ logger.error(msg, args); }
	
	public void fatal(Marker mark, Object msg){ logger.fatal(mark, msg); }
	
	public void fatal(Marker mark, Object msg, Throwable thrown){ logger.fatal(mark, msg, thrown); }
	
	public void fatal(Marker mark, String msg, Object... args){ logger.fatal(mark, msg, args); }
	
	public void fatal(Object msg){ logger.fatal(msg); }
	
	public void fatal(Object msg, Throwable thrown){ logger.fatal(msg, thrown); }
	
	public void fatal(String msg, Object... args){ logger.fatal(msg, args); }
	
	public void info(Marker mark, Object msg){ logger.info(mark, msg); }
	
	public void info(Marker mark, Object msg, Throwable thrown){ logger.info(mark, msg, thrown); }
	
	public void info(Marker mark, String msg, Object... args){ logger.info(mark, msg, args); }
	
	public void info(Object msg){ logger.info(msg); }
	
	public void info(Object msg, Throwable thrown){ logger.info(msg, thrown); }
	
	public void info(String msg, Object... args){ logger.info(msg, args); }
	
	public void log(Level lvl, Marker mark, Object msg){ logger.log(lvl, mark, msg); }
	
	public void log(Level lvl, Marker mark, Object msg, Throwable thrown){ logger.log(lvl, mark, msg, thrown); }
	
	public void log(Level lvl, Marker mark, String msg, Object... args){ logger.log(lvl, mark, msg, args); }
	
	public void log(Level lvl, Object msg){ logger.log(lvl, msg); }
	
	public void log(Level lvl, Object msg, Throwable thrown){ logger.log(lvl, msg, thrown); }
	
	public void log(Level lvl, String msg, Object... args){ logger.log(lvl, msg, args); }
	
	public void printf(Level lvl, Marker mark, String msg, Object... args){ logger.printf(lvl, mark, msg, args); }
	
	public void printf(Level lvl, String msg, Object... args){ logger.printf(lvl, msg, args); }
	
	public void throwing(Throwable thrown){ logger.catching(thrown); }
	
	public void throwing(Level lvl, Throwable thrown){ logger.catching(lvl, thrown); }
	
	public void trace(Marker mark, Object msg){ logger.trace(mark, msg); }
	
	public void trace(Marker mark, Object msg, Throwable thrown){ logger.trace(mark, msg, thrown); }
	
	public void trace(Marker mark, String msg, Object... args){ logger.trace(mark, msg, args); }
	
	public void trace(Object msg){ logger.trace(msg); }
	
	public void trace(Object msg, Throwable thrown){ logger.trace(msg, thrown); }
	
	public void trace(String msg, Object... args){ logger.trace(msg, args); }
	
	public void warn(Marker mark, Object msg){ logger.warn(mark, msg); }
	
	public void warn(Marker mark, Object msg, Throwable thrown){ logger.warn(mark, msg, thrown); }
	
	public void warn(Marker mark, String msg, Object... args){ logger.warn(mark, msg, args); }
	
	public void warn(Object msg){ logger.warn(msg); }
	
	public void warn(Object msg, Throwable thrown){ logger.warn(msg, thrown); }
	
	public void warn(String msg, Object... args){ logger.warn(msg, args); }
	
}
