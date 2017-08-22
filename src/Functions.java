import java.util.ArrayList;
import java.util.Stack;

import java.util.Hashtable;

import javax.swing.*;

public class Functions {
	public ArrayList<String> code = new ArrayList<String>();
	public Hashtable<String, String> registers = new Hashtable<String, String>();
	public Hashtable<String, Integer> flag = new Hashtable<String, Integer>();
	public Hashtable<String,Integer> jump=new Hashtable<String,Integer>();
	Stack stack = new Stack();
	public Functions() {
		registers.put("ax", new String(Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)));
		registers.put("bx", new String(Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)));
		registers.put("cx", new String(Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)));
		registers.put("dx", new String(Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)));
		registers.put("cs", new String(Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)));
		registers.put("ip", new String(Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)));
		registers.put("ss", new String(Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)));
		registers.put("sp", new String(Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)));
		registers.put("bp", new String(Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)));
		registers.put("si", new String(Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)));
		registers.put("di", new String(Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)));
		registers.put("ds", new String(Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)));
		registers.put("es", new String(Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)));
		
		flag.put("cf", new Integer(0));
		flag.put("zf", new Integer(0));
		flag.put("sf", new Integer(0));
		flag.put("of", new Integer(0));
		flag.put("pf", new Integer(0));
		flag.put("df", new Integer(0));
	}

	public void getCode(JTextArea codeArea) {
		int i=0;
		for (String line : codeArea.getText().split("\\n")) {
			if(line.charAt(line.length()-1)==':')
				{
				String []str=line.split(":");
				jump.put(str[0], new Integer(i));
				}
			code.add(line);
			i++;
		}
		runAllLine();

	}

	public void runAllLine() {
		int i=0;//String line : code
		for (i=0;i<code.size();i++) {
			String separation[] = code.get(i).split("[,\\s]+");
			if (separation[0].equalsIgnoreCase("mov")) {

				moveInstr(separation[1], separation[2]);
			}

			else if (separation[0].equalsIgnoreCase("inc")||separation[0].equalsIgnoreCase("dec")||separation[0].equalsIgnoreCase("not")) {
				/* increment function */
				incDec(separation[1],separation[0]);
			}

			else if (separation[0].equalsIgnoreCase("or")||separation[0].equalsIgnoreCase("and")||separation[0].equalsIgnoreCase("xor")||separation[0].equalsIgnoreCase("add")) {
				/* increment function */
				orAndXor(separation[1], separation[2],separation[0]);
			}
			/***********set flags***************/
			else if (separation[0].equalsIgnoreCase("stc")||separation[0].equalsIgnoreCase("std")) {
				setFlags(separation[0]);
			}
			/***********clear flags***************/
			else if (separation[0].equalsIgnoreCase("clc")||separation[0].equalsIgnoreCase("cld")) {
				clearFlags(separation[0]);
			}
			
			/***********shifting flags***************/
			else if (separation[0].equalsIgnoreCase("shr")||separation[0].equalsIgnoreCase("shl")||separation[0].equalsIgnoreCase("ror")) {
				shifting(separation[1], separation[2],separation[0]);
			}
			
			/**************LABELS***********************/
			else if(separation[0].charAt(separation[0].length()-1)==':')
			{
				
				System.out.println(separation[0]);
				
			}
			
			/***************** JUMPS *************************/
			else if (separation[0].equalsIgnoreCase("jmp")) {
				
					int jmp=jump.get(separation[1]);
					System.out.println(jmp+"ffffffffffff");
					i=jmp;
			}
			
			else if (separation[0].equalsIgnoreCase("ja")) {
				
				if(flag.get("cf")==0&&flag.get("zf")==0)
				{
					i=jump.get(separation[1]);
				}
		}
			
			else if (separation[0].equalsIgnoreCase("jae")) {
							
							if(flag.get("cf")==0)
							{
								i=jump.get(separation[1]);
							}
					}
			else if (separation[0].equalsIgnoreCase("jb")) {
				
				if(flag.get("cf")==1)
				{
					i=jump.get(separation[1]);
				}
		}
			
			else if (separation[0].equalsIgnoreCase("jbe")) {
				
				if(flag.get("cf")==1&&flag.get("zf")==1)
				{
					i=jump.get(separation[1]);
				}
		}
			
			else if (separation[0].equalsIgnoreCase("je")) {
				
				if(flag.get("zf")==1)
				{
					i=jump.get(separation[1]);
				}
		}
			
			else if (separation[0].equalsIgnoreCase("jg")) {
				
				if(flag.get("zf")==0&&(flag.get("sf")==flag.get("of")))
				{
					i=jump.get(separation[1]);
				}
		}
			
			else if (separation[0].equalsIgnoreCase("jge")) {
							
							if(flag.get("sf")==flag.get("of"))
							{
								i=jump.get(separation[1]);
							}
					}
			else if (separation[0].equalsIgnoreCase("jl")) {
				
				if(flag.get("sf")!=flag.get("of"))
				{
					i=jump.get(separation[1]);
				}
		}
			
				else if (separation[0].equalsIgnoreCase("jle")) {
								
								if(flag.get("zf")==1||(flag.get("sf")!=flag.get("of")))
								{
									i=jump.get(separation[1]);
								}
						}
			
				else if (separation[0].equalsIgnoreCase("je")) {
					
					if(flag.get("zf")==0)
					{
						i=jump.get(separation[1]);
					}
			}
			
			else if (separation[0].equalsIgnoreCase("jnp")||separation[0].equalsIgnoreCase("jpo")) {
								
								if(flag.get("pf")==0)
								{
									i=jump.get(separation[1]);
								}
						}
			
			else if (separation[0].equalsIgnoreCase("jp")) {
				
				if(flag.get("pf")==1)
				{
					i=jump.get(separation[1]);
				}
		}
			/********************PUSH**********************/
			else if (separation[0].equalsIgnoreCase("push")) {
				if(separation[1].length()==2&&(separation[1].charAt(1)=='x'||separation[1].equals("di")||separation[1].equals("si")||separation[1].equals("bp")||separation[1].equals("sp")))
				{
					stack.push(registers.get(separation[1]));
				}
				else if(separation[1].charAt(separation[1].length()-1)=='h'&&separation[1].length()<=5)
				{
					String str=separation[1].substring(0,separation[1].length()-1);
					
					stack.push(str);
				}
				else
				{
					int value=Integer.parseInt(separation[1]);
					if(value<65536)
					{
						stack.push(Integer.toHexString(value));
					}
				}
				/*** no operation */
			}
			/*****************POP**************************/
			else if (separation[0].equalsIgnoreCase("pop")) {
				if(separation[1].length()==2&&(separation[1].charAt(1)=='x'||separation[1].equals("di")||separation[1].equals("si")||separation[1].equals("bp")||separation[1].equals("sp")))
				{
					String str=putEditionHex((String)stack.pop(),separation[1]);
					registers.put(separation[1], str);
					System.out.println(str);
				}
				
			}
			
			/********************NO OPERATION**********************/
			else if (separation[0].equalsIgnoreCase("nop")) {

				/*** no operation */
			}
			else if (separation[0].equalsIgnoreCase("hlt")) {

				break;
			}
		}
	}

	void moveInstr(String dest, String source) {
			/************REG-DEC_IMD ********************/
		if (source.length() >= 1
				&& (source.charAt((source.length() - 1))) != 'h'
				&& (IsRegister(source)==false)
				&&(IsRegister(dest)==true)) {
			
			if (dest.charAt(1) == 'l' || dest.charAt(1) == 'L'
					|| dest.charAt(1) == 'H' || dest.charAt(1) == 'h') {
				String str = lowHighEdition(source, dest);
				dest = dest.charAt(0) + "x";
				registers.put(dest, str);

			} else // ///16bitliklere decimal
			{
				int convert = Integer.parseInt(source);
				String toStr = Integer.toHexString(convert);
				if (convert < 0)
					toStr = toStr.substring(4, 8);
				if(toStr.length()==3)
				{
					toStr=Integer.toHexString(0)+toStr;
				}
				else if(toStr.length()==2)
				{
					toStr=Integer.toHexString(0)+Integer.toHexString(0)+toStr;
				}
				else if(toStr.length()==1)
				{
					toStr=Integer.toHexString(0)+Integer.toHexString(0)+Integer.toHexString(0)+toStr;
				}
				registers.put(dest, toStr);
			}
			

		}
		
		/*************REG-HEX-IMD***********************/
		else	if (source.length() >= 2
				&& (source.charAt((source.length() - 1))) == 'h'
				&& IsRegister(dest))
		{
			/******REG-HEX-IMD 16b******************/
			if(IsRegister(dest)&&(dest.charAt(1)!='h')&&(dest.charAt(1)!='l'))
			{
				source=source.substring(0,source.length()-1);
				source=putEditionHex(source,dest);
				registers.put(dest, source);
			}
			/******REG-HEX-IMD 8b******************/
			if((dest.charAt(1)=='h'||dest.charAt(1)=='l'))
			{
				source=source.substring(0,source.length()-1);
				source=putEditionHex(source,dest);
				registers.put(dest.charAt(0)+"x", source);
			}
		}
		/******************REG-REG 16 bit*************************/
		else if ( IsRegister(dest)
				&&(IsRegister(source))
				&&(dest.charAt(1)!='h'&&dest.charAt(1)!='l'&&source.charAt(1)!='h'&&source.charAt(1)!='l')
				)
		{
			String value=registers.get(source);
			registers.put(dest, value);
		}
		
		/******************REG-REG 8 bit*************************/
		else if ( IsRegister(dest)
				&&(IsRegister(source))
				&&((dest.charAt(1)!='h'||dest.charAt(1)!='l')&&(source.charAt(1)!='h'||source.charAt(1)!='l'))
				)
		{
			if(dest.charAt(1)=='h'||dest.charAt(1)=='l')
			{
				if(source.charAt(1)=='l')
				{
					String value=getLowValue(source.charAt(0)+"x");
					String str=putEditionHex(value,  dest);
					registers.put(dest.charAt(0)+"x",str);
				}
				else if(source.charAt(1)=='h')
				{
					String value=getHighValue(source.charAt(0)+"x");
					String str=putEditionHex(value,  dest);
					registers.put(dest.charAt(0)+"x",str);
				}
			}
			
		}
		
		/**********MEMORY-REG**********************/
		if(dest.length()>2)
		{
			String [] separate=dest.split("[\\(\\.\\)\\s]+");
			for(String line:separate)
			System.out.println(dest+" sssssssssssssssssss"+line);
		}
		
	}

	void incDec(String dest,String command) {
		/****** REG 16bit ******/
		if (dest.length() == 2 && dest.charAt(1) == 'x') {
			int value = Integer.parseInt(registers.get(dest), 16);
			if(command.equals("inc"))
			value++;
			else if(command.equals("dec"))
				value--;
			else if(command.equals("not"))
				value=~value;
			
			if(value>65535||value==0)
			{
					flag.put("zf", 1);
				    value=0;
				
			}
			else 
				flag.put("zf", 0);
			if(!command.equals("not"))
			FlagUpdate(value,true,command);
			String val=putEditionHex(Integer.toHexString(value),dest);
			registers.put(dest,val );
		}
		/****** REG 8 bit high ******/
		else if (dest.length() == 2 && (dest.charAt(1) == 'h')) {
			int value=Integer.parseInt(getHighValue(dest.charAt(0)+"x"),16);
			if(command.equals("inc"))
				value++;
				else if(command.equals("dec"))
					value--;
				else if(command.equals("not"))
					value=~value;
			if(value>255||value==0)
			{
					flag.put("zf", 1);
				    value=0;
				
			}
			else 
				flag.put("zf", 0);
			if(!command.equals("not"))
			FlagUpdate(value,false,command);
			String str=lowHighEdition(Integer.toString(value),  dest);
			registers.put(dest.charAt(0)+"x",str);
		}
		/****** REG 8 bit low******/
		else if (dest.length() == 2 && (dest.charAt(1) == 'l')) {
			int value=Integer.parseInt(getLowValue(dest.charAt(0)+"x"),16);
			if(command.equals("inc"))
				value++;
				else if(command.equals("dec"))
					value--;
				else if(command.equals("not"))
					value=~value;
			if(value>255||value==0)
			{
					flag.put("zf", 1);
				    value=0;
				
			}
			else 
				flag.put("zf", 0);
			if(!command.equals("not"))
			FlagUpdate(value,false,command);
			String str=lowHighEdition(Integer.toString(value),  dest);
			registers.put(dest.charAt(0)+"x",str);
		}
	}
   void shifting(String dest,String num,String command)
   {
	   
		   /****** REG 16bit ******/
			if (dest.length() == 2 && dest.charAt(1) == 'x') {
				int value = Integer.parseInt(registers.get(dest), 16);
			    boolean signP=false,signAfterP=false;
			    if(value<32768)
			    	{
			    	signP=true;
			    	}
				int sVal=Integer.parseInt(num);
				String cf=null;
				char[] charArray = Integer.toBinaryString(value).toCharArray();
				if(command.equals("shr"))
				{
				value=value>>sVal;
				cf=""+charArray[(charArray.length-sVal)];
				}
				
				else if(command.equals("shl"))
				{
					if(value<32768)
						cf="0";
					else
					cf=""+charArray[(sVal-1)];
				value=value<<sVal;
				
				}
				else if(command.equals("ror"))
				{
					 
					value=Integer.rotateRight(value, sVal);
					String v=Integer.toString(value );
					String hex = Integer.toHexString(value );
					if(value<32768)
						cf="0";
					else
					cf=""+charArray[(sVal-1)];
				
				}
				
				flag.put("cf", Integer.parseInt(cf));
				
				if(value<32768)
			    	{
					signAfterP=true;
			    	}
				
				if(signAfterP==signP)
				{
					flag.put("of", 0);
				}
				else 
					{
					flag.put("of", 1);
					}
				
				FlagUpdate(value,true,command);
				String val=putEditionHex(Integer.toHexString(value),dest);
				registers.put(dest,val );
			}
		   
			/****** REG-REG 8bit ******/
			else if ( dest.length() == 2
					&& (dest.charAt(1) == 'l' || dest.charAt(1) == 'h')) {
				int value=0;
				if(dest.charAt(1) == 'l')
				{
					 value=Integer.parseInt(getLowValue(dest.charAt(0) + "x"),16);
					  
				}
				else if(dest.charAt(1) == 'h')
				{
					 value=Integer.parseInt(getHighValue(dest.charAt(0) + "x"),16);
					 
				}
				
				 boolean signP=false,signAfterP=false;
				    if(value<32768)
				    	{
				    	signP=true;
				    	}
					int sVal=Integer.parseInt(num);
					String cf=null;
					char[] charArray = Integer.toBinaryString(value).toCharArray();
					if(command.equals("shr"))
					{
					value=value>>sVal;
					cf=""+charArray[(charArray.length-sVal)];
					}
					
					else if(command.equals("shl"))
					{
						if(value<32768)
							cf="0";
						else
						cf=""+charArray[(sVal-1)];
					value=value<<sVal;
					
					}
					else if(command.equals("ror"))
					{
						 
						value=Integer.rotateRight(value, sVal);
						String v=Integer.toString(value );
						String hex = Integer.toHexString(value );
						if(value<32768)
							cf="0";
						else
						cf=""+charArray[(sVal-1)];
					
					}
					
					flag.put("cf", Integer.parseInt(cf));
					
					if(value<32768)
				    	{
						signAfterP=true;
				    	}
					
					if(signAfterP==signP)
					{
						flag.put("of", 0);
					}
					else 
						{
						flag.put("of", 1);
						}
					
					FlagUpdate(value,true,command);
				String str=lowHighEdition(Integer.toString(value),  dest);
				registers.put(dest.charAt(0)+"x",str);
				
			}
				
	   
   }
	void orAndXor(String dest, String source, String command) {
		if(IsRegister(source)&&IsRegister(dest))
		
		{
			/***** REG-REG 16bit *****/
		
		if (source.length() == 2 && source.charAt(1) == 'x'
				&& dest.length() == 2 && dest.charAt(1) == 'x') {

			int value1 = Integer.parseInt(registers.get(dest), 16);
			int value2 = Integer.parseInt(registers.get(source), 16);
			if(command.equals("or"))
			value1 = value1 | value2;
			else if(command.equals("xor"))
				value1 = value1 ^ value2;
			else if(command.equals("and"))
				value1 = value1 & value2;
			/*******************add*********************/
			else if(command.equals("add"))
			{
				value1=value1+value2;
				if(value1>65535)
				{
					flag.put("cf", 1);
					flag.put("zf", 1);
					value1=0;
				}
			}
			 FlagUpdate(value1,true,command);
			registers.put(dest, Integer.toHexString(value1));
		}

		/****** REG-REG 8bit ******/
		else if (source.length() == 2
				&& (source.charAt(1) == 'l' || source.charAt(1) == 'h')
				&& dest.length() == 2
				&& (dest.charAt(1) == 'l' || dest.charAt(1) == 'h')) {
			int value1=0,value2=0;
			if(dest.charAt(1) == 'l')
			{
				 value1=Integer.parseInt(getLowValue(dest.charAt(0) + "x"),16);
				  if(source.charAt(1) == 'h')
					{
						 value2=Integer.parseInt(getHighValue(source.charAt(0) + "x"),16);
					}
				 else if(source.charAt(1) == 'l')
					{
						 value2=Integer.parseInt(getLowValue(source.charAt(0) + "x"),16);
					}
			}
			else if(dest.charAt(1) == 'h')
			{
				String str1=getHighValue(dest.charAt(0) + "x");
				 value1=Integer.parseInt(getHighValue(dest.charAt(0) + "x"),16);
				 if(source.charAt(1) == 'h')
					{
						 value2=Integer.parseInt(getHighValue(source.charAt(0) + "x"),16);
					}
				 else if(source.charAt(1) == 'l')
					{
						 value2=Integer.parseInt(getLowValue(source.charAt(0) + "x"),16);
					}
			}
			
			if(command.equals("or"))
				value1 = value1 | value2;
				else if(command.equals("xor"))
					value1 = value1 ^ value2;
				else if(command.equals("and"))
					value1 = value1 & value2;
				else if(command.equals("add"))
				{
					value1=value1+value2;
					if(value1>65535)
					{
						flag.put("cf", 1);
						flag.put("zf", 1);
						value1=0;
					}
				}
			FlagUpdate(value1,false,command);
			String str=lowHighEdition(Integer.toString(value1),  dest);
			registers.put(dest.charAt(0)+"x",str);
			
		}
		}
		//*******REG-IMDT***///
		else if(IsRegister(dest))
		{
			int value1=0;
			int value2=0;
			if(dest.charAt(1) == 'l')
			{
				 value1=Integer.parseInt(getLowValue(dest.charAt(0) + "x"),16);
				  
			}
			else if(dest.charAt(1) == 'h')
			{
				 value1=Integer.parseInt(getHighValue(dest.charAt(0) + "x"),16);
				 
			}
			else
				value1=Integer.parseInt(registers.get(dest),16);
			if(source.charAt(source.length()-1)=='h')
				value2=Integer.parseInt(source.substring(0,source.length()-1),16);
			else
				value2=Integer.parseInt(source,16);
			if(command.equals("or"))
				value1 = value1 | value2;
				else if(command.equals("xor"))
					value1 = value1 ^ value2;
				else if(command.equals("and"))
					value1 = value1 & value2;
				else if(command.equals("add"))
				{
					value1=value1+value2;
					if(value1>65535)
					{
						flag.put("cf", 1);
						flag.put("zf", 1);
						value1=0;
						System.out.println(Integer.toHexString(value1)+" "+value1);
					}
				}
			if(dest.charAt(1)!='x')
			{
				String str=lowHighEdition(Integer.toString(value1),  dest);
				FlagUpdate(value1,false,command);
				registers.put(dest.charAt(0)+"x",str);
			}
			else 
				{
				FlagUpdate(value1,true,command);
				registers.put(dest, Integer.toHexString(value1));
				}
		}
		
		
		
	}

	String getLowValue(String register) {
		String value = registers.get(register);
		value = value.substring(2,4);
		return value;
	}
	
	String getHighValue(String register) {
		String value = registers.get(register);
		value = value.substring(0, 2);
		return value;
	}

	String lowHighEdition(String source, String dest)// //source decimal
	{
		String str = null;
		int convert = Integer.parseInt(source);
		StringBuilder ax = null;
		if (convert < 256) {
			String toStr = Integer.toHexString(convert);
			if (convert < 0)
				toStr = toStr.substring(6, 8);
			if(toStr.length()==1)
				toStr =Integer.toHexString(0)+toStr;
			char LoH = dest.charAt(1);
			dest = dest.charAt(0) + "x";
			ax = new StringBuilder(registers.get(dest));
			if (LoH == 'l') {
			ax.setCharAt(3, toStr.charAt(1));
			ax.setCharAt(2, toStr.charAt(0));
			
			} 
			
			else if (LoH == 'h') {
				ax.setCharAt(1, toStr.charAt(1));
				ax.setCharAt(0, toStr.charAt(0));
			}
			return ax.toString();
		}
		return null;
	}

	String putEditionHex(String source,String dest)//hex
	{
		StringBuilder str=new StringBuilder(source);
		if(dest.charAt(1)=='h'||dest.charAt(1)=='l'){
			StringBuilder ax=new StringBuilder(registers.get(dest.charAt(0)+"x"));
			 if(str.length()==1&&dest.charAt(1)!='h')
			{
				 ax.setCharAt(3, source.charAt(0));
					ax.setCharAt(2, '0');
			}
			 else if(str.length()==2&&dest.charAt(1)!='h')
				{
				 	ax.setCharAt(3, source.charAt(1));
					ax.setCharAt(2, source.charAt(0));
				}
			 else if(str.length()==1&&dest.charAt(1)!='l')
				{
				 ax.setCharAt(0, '0');
					ax.setCharAt(1, source.charAt(0));
				}
			 else if(str.length()==2&&dest.charAt(1)!='l')
				{
				 ax.setCharAt(0, source.charAt(0));
					ax.setCharAt(1, source.charAt(1));
				}
			return ax.toString();
		}
		else
		{
			StringBuilder ax=new StringBuilder(registers.get(dest));
		if(str.length()==1)
		{
			str.insert(0,"000");
		}
		else if(str.length()==2)
		{
			str.insert(0,"00");
		}
		else if(str.length()==3)
		{
			str.insert(0,"0");
		}
		else if(str.length()>3)
		{
			ax.setCharAt(0, source.charAt(source.length()-4));
			ax.setCharAt(1, source.charAt(source.length()-3));
			ax.setCharAt(2, source.charAt(source.length()-2));
			ax.setCharAt(3, source.charAt(source.length()-1));
			return ax.toString();
		}
	}
		
		return str.toString();
	}
	
	void FlagUpdate(int value,boolean is16,String command)
	{
	   int count=0;
	   int pf,zf,sf;
		char[] charArray = Integer.toBinaryString(value).toCharArray();
		String str=Integer.toHexString(value);
		for(int i=0;i<charArray.length;i++)
			if(charArray[i]=='1')
				count++;
		if(count%2==0)
			pf=1;
		else pf=0;;
		
		if(is16)
		{
			if(str.equals("8000")&&command.equals("inc"))
				flag.put("of", 1);
			else if (str.equalsIgnoreCase("7FFF")&&command.equals("dec"))
				flag.put("of", 1);
			
			if(value>32767)
				{
				sf=1;
				}
			else 
				sf=0;
			
			if(value==0)
				zf=1;
			else 
				zf=0;
		}
		else {
			if(str.equals("80")&&command.equals("inc"))
				flag.put("of", 1);
			else if (str.equalsIgnoreCase("7F")&&command.equals("dec"))
				flag.put("of", 1);
			
			if(value>127)
				sf=1;
			else 
				sf=0;
			
			if(value==0)
				zf=1;
			else 
				zf=0;
		}
		
if(command.equals("inc")||command.equals("dec"))
{
	flag.put("cf", 0);
	flag.put("sf", sf);
	flag.put("pf", pf);
	flag.put("df", 0);
}
else if(command.equals("or")||command.equals("and")||command.equals("xor"))
{
	flag.put("cf", 0);
	flag.put("zf", zf);
	flag.put("sf", sf);
	flag.put("of", 0);
	flag.put("pf", pf);
	flag.put("df", 0);
}	

else if(command.equals("shr")||command.equals("shl")||command.equals("ror"))
{
	flag.put("zf",zf);
	flag.put("sf", sf);
	flag.put("pf", pf);
	flag.put("df", 0);
}	
else if(command.equals("add"))
{
	flag.put("sf", sf);
	flag.put("pf", pf);
	flag.put("df", 0);
}	
	}
	
void setFlags(String command)
{
	flag.put(command.charAt(2)+"f", 1);
}
void clearFlags(String command)
{
	flag.put(command.charAt(2)+"f", 0);
}
	boolean IsRegister(String str)
	{
		if(str.length()>=2)
		if(str.charAt(1)=='x'||str.charAt(1)=='h'||str.charAt(1)=='l'||str.equalsIgnoreCase("sp")||str.equalsIgnoreCase("si")||str.equalsIgnoreCase("di")||str.equalsIgnoreCase("ds"))
		return true;
		return false;
	}
}
