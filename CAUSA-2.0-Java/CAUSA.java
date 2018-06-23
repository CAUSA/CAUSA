/*
==============================================================
CAUSA 2.0.0 -- java version
This software is released under GNU/GPL license
Copyright (c) 2011, Ocean University of China
==============================================================
Written by:                   
Xiaolong Wang* @ Ocean University of China 
Pedamallu Chandra Sekhar  @ The Broad Institute and DFCI

*To whom corresponding should be addressed
email: xiaolong@ouc.edu.cn
website: http://www.CAUSA.com

Usage: Codon and Amino acid Unified Sequence Alignment (CAUSA)

 CAUSA <Name of protein coding DNA sequences (in fasta format)>
================================================================

*/

import java.io.*;
//import java.util.*;

public class CAUSA{
	public void createSeqFile(String namefile, String nameout){
		try{
			
				System.out.println("Create combined sequence file");
				//Read file
				FileReader fr=new FileReader(namefile);
				BufferedReader br=new BufferedReader(fr);
				String record=new String();

				BufferedWriter out=new BufferedWriter(new FileWriter(nameout));

				int Start=0;
				String codon="";
				int fline=0; // frist line
				while((record=br.readLine()) != null){
					String rec = record.trim();
					//System.out.println(rec);

					if(rec.length() > 0){

							char rec_char[]=rec.toCharArray();

							//Name of the Sequence
							if(rec_char[0]=='>'){
								if(fline==0){
									out.write(rec+"\n");
								}
								else{
									out.write("\n"+rec+"\n");
								}
								Start=1;
								fline++;
							}
							else{
								if(Start==1){
									// Replace all spaces with none
									String rec1=rec.replaceAll(" ", "");
									char rec_char1[]=rec1.toCharArray();

									// Look for codon and its representations in Amino acid
									for(int i=0; i<rec1.length(); i++){
										 if (("agctu".indexOf(rec_char1[i]) != -1) || ("AGCTU".indexOf(rec_char1[i]) != -1)){ 
											codon=codon+""+rec_char1[i];
											}

										if(codon.length() ==3){

											String codon1=codon.toUpperCase();

											String amino="";
											if((codon1.equals("GCT")) || (codon1.equals("GCU"))){
												//amino="A";
												codon1="GCU";
												amino="B";
											}
											else if ((codon1.equals("GCC"))||(codon1.equals("GCA"))||(codon1.equals("GCG"))){
												amino="B";
											}
											else if((codon1.equals("CGU")) || (codon1.equals("CGT"))){
												codon1="CGU";
												amino="R";
											}
											else if ((codon1.equals("CGC"))||(codon1.equals("CGA"))||(codon1.equals("CGG"))||(codon1.equals("AGA"))||(codon1.equals("AGG"))){
												amino="R";
											}
											else if((codon1.equals("AAU")) || (codon1.equals("AAT"))){
												codon1="AAU";
												amino="N";
											}
											else if(codon1.equals("AAC")){
												amino="N";
											}
											else if((codon1.equals("GAU")) || (codon1.equals("GAT"))){
												codon1="GAU";
												amino="D";
											}
											else if((codon1.equals("GAC"))){
												amino="D";
											}
											else if((codon1.equals("UGC"))||(codon1.equals("TGC"))){
												codon1="UGC";
												//amino="C";
												amino="X";
											}
											else if((codon1.equals("UGU")) || (codon1.equals("TGT"))){
												codon1="UGU";
												//amino="C";
												amino="X";
											}
											else if((codon1.equals("CAA")) || (codon1.equals("CAG"))){
												amino="Q";
											}
											else if((codon1.equals("GAA")) || (codon1.equals("GAG"))){
												amino="E";
											}
											else if((codon1.equals("GGU")) || (codon1.equals("GGT"))){
												codon1="GGU";
												//amino="G";
												amino="Z";
											}
											else if((codon1.equals("GGC"))|| (codon1.equals("GGA"))|| (codon1.equals("GGG"))){
												//amino="G";
												amino="Z";
											}
											else if((codon1.equals("CAU")) || (codon1.equals("CAT"))){
												codon1="CAU";
												amino="H";
											}
											else if((codon1.equals("CAC"))){
												amino="H";
											}
											else if((codon1.equals("AUU")) || (codon1.equals("ATT"))){
												codon1="AUU";
												amino="I";
											}
											else if((codon1.equals("AUC"))|| (codon1.equals("ATC"))){
												codon1="AUC";
												amino="I";
											}
											else if((codon1.equals("AUA"))|| (codon1.equals("ATA"))){
												codon1="AUA";
												amino="I";
											}
											else if((codon1.equals("AUG")) || (codon1.equals("ATG"))){
												codon1="AUG";
												amino="M";
											}
											else if((codon1.equals("UUG")) || (codon1.equals("TTG"))){
												codon1="UUG";
												amino="L";
											}
											else if((codon1.equals("UUA"))|| (codon1.equals("TTA"))){
												codon1="UUA";
												amino="L";
											}
											else if((codon1.equals("CUU"))|| (codon1.equals("CTT"))){
												codon1="CUU";
												amino="L";
											}
											else if((codon1.equals("CUC"))|| (codon1.equals("CTC"))){
												codon1="CUC";
												amino="L";
											}
											else if((codon1.equals("CUA"))|| (codon1.equals("CTA"))){
												codon1="CUA";
												amino="L";
											}
											else if((codon1.equals("CUG"))|| (codon1.equals("CTG"))){
												codon1="CUG";
												amino="L";
											}
											else if((codon1.equals("UUU")) || (codon1.equals("TTT"))){
												codon1="UUU";
												amino="F";
											}
											else if((codon1.equals("UUC")) || (codon1.equals("TTC"))){
												codon1="UUC";
												amino="F";
											}
											else if((codon1.equals("CCU")) || (codon1.equals("CCT"))){
												codon1="CCU";
												amino="P";
											}
											else if((codon1.equals("CCC")) || (codon1.equals("CCA"))|| (codon1.equals("CCG"))){
												amino="P";
											}
											else if((codon1.equals("UCU")) || (codon1.equals("TCT"))){
												codon1="UCU";
												amino="S";
											}
											else if((codon1.equals("UCC")) || (codon1.equals("TCC"))){
												codon1="UCC";
												amino="S";
											}
											else if((codon1.equals("UCA"))|| (codon1.equals("TCA"))){
												codon1="UCA";
												amino="S";
											}
											else if((codon1.equals("UCG"))|| (codon1.equals("TCG"))){
												codon1="UCG";
												amino="S";
											}
											else if((codon1.equals("AGU"))|| (codon1.equals("AGT"))){
												codon1="AGU";
												amino="S";
											}
											else if((codon1.equals("AGC"))){
												amino="S";
											}
											else if((codon1.equals("ACU")) || (codon1.equals("ACT"))){
												codon1="ACU";
												amino="T";
											}
											else if((codon1.equals("ACC")) || (codon1.equals("ACA"))|| (codon1.equals("ACG"))){
												amino="T";
											}

											else if((codon1.equals("UGG")) || (codon1.equals("TGG"))){
												codon1="UGG";
												amino="W";
											}
											else if((codon1.equals("UAU")) || (codon1.equals("TAT")) ){
												codon1="UAU";
												amino="Y";
											}
											else if((codon1.equals("UAC")) ||(codon1.equals("TAC"))){
												codon1="UAC";
												amino="Y";
											}
											else if((codon1.equals("GUU")) || (codon1.equals("GTT"))){
												codon1="GUU";
												amino="V";
											}
											else if((codon1.equals("GUC")) ||(codon1.equals("GTC"))){
												codon1="GUC";
												amino="V";
											}
											else if((codon1.equals("GUA"))||(codon1.equals("GTA"))){
												codon1="GUA";
												amino="V";
											}
											else if((codon1.equals("GUG"))||(codon1.equals("GTG"))){
												codon1="GUG";
												amino="V";
											}
											else if((codon1.equals("UAA")) || (codon1.equals("TAA"))){
												codon1="UAA";
												amino="*";
											}
											else if((codon1.equals("UGA")) ||(codon1.equals("TGA"))){
												codon1="UGA";
												amino="*";
											}
											else if((codon1.equals("UAG"))||(codon1.equals("TAG"))){
												codon1="UAG";
												amino="*";
											}
											else if((codon1.equals("AAA"))||(codon1.equals("AAG"))){
												amino="K";
											}
											out.write(amino+""+codon1.toLowerCase());

											codon="";
										}

									}
								}

							}
						}
				}

				fr.close();
				out.close();
			}catch(Exception e){System.out.println(e);}
	}
    public void ResolveCAUSA(String namefile, String nameout)
    {
    	
		try{
	        //Read CAUSA Seq		
			System.out.println("Reading FASTA sequence file");
			//Read fasta file
			FileReader fr=new FileReader(namefile);
			BufferedReader br=new BufferedReader(fr);
			String record=new String();
			int TotalSeq;
			String[] SeqName= new String[1000];
			String[] SeqData= new String[1000]; 
		    String[] ResolvedAlignment = new String[1000];
			
			int i=0;
			while((record=br.readLine()) != null){
				
				String rec = record.trim();
				
				if(rec.length() > 0){

						char rec_char[]=rec.toCharArray();

						//Name of the Sequence
						if(rec_char[0]=='>'){
							i++;
							SeqName[i]=rec;
							SeqData[i]="";
							if (i>1) {System.out.println(SeqData[i-1].length()+" Sites\n");}
							System.out.println("Sequence "+i+": "+SeqName[i]+", ");

						}
						else{
							SeqData[i]=SeqData[i]+rec;
						}
				}

			}
			if (i>1) {System.out.println(SeqData[i].length()+" Sites\n");}
			TotalSeq=i;
			fr.close();

        int SeqLen, ThisLen, SeqPosition;
        
        //Resolve CAUSA
        SeqLen = SeqData[1].length();

        if (TotalSeq < 2 || SeqLen == 0)
        {
            System.out.println("\nError in reading ClustalW output file. " + nameout+"\n");
            return;
        } 
        
        System.out.println("ClustalW output: total sequences read: " + TotalSeq);   

        for (i = 1; i <= TotalSeq; i++)
        {			
            //if (SeqName[i].substring(1, 1).toUpperCase() == "P")//Delete Program numbers inserted by ClusralW
            //{
             SeqName[i] = SeqName[i].substring(4, SeqName[i].length());
           // }
			System.out.println("Sequence "+i+": "+SeqName[i]+", "+SeqData[i].length()+" Sites");
           // long j = Long.parseLong(SeqName[i].substring(0, SeqName[i].indexOf('.')));
           // SeqName[i]=FullSeqName[j];
			ResolvedAlignment[i] = "";
        }

        //	boolean IsMitochandrialDNA = false;
        
        System.out.println("\nResolving unified alignment: \n");   
        String ThisSeq="";
        String ThisSymbol="", ThisAA ="", ThisBase ="", ThisCodon = "";
               
        for (SeqPosition = 0; SeqPosition < SeqLen; SeqPosition++)
        {
            for (i = 1; i <= TotalSeq; i++)
            {
            	//System.out.println("Position: " + SeqPosition + ", Sequence: " + i + SeqData[i]);   
               
            	ThisSeq = SeqData[i];
            	ThisSymbol = ThisSeq.substring(SeqPosition,SeqPosition+1);
                              
                if ("BDEFHIJKLMNOPQRSTVWXYZ".indexOf(ThisSymbol) + 1 > 0)
                {
                    ThisAA = ThisSymbol;
                    if (ThisAA.equals("B")) ThisAA = "A";
                    if (ThisAA.equals("X")) ThisAA = "C";
                    if (ThisAA.equals("Z")) ThisAA = "G";
                    if (ThisAA.equals("O")) ThisAA = "*";

                    // Using (1) and (2) to keep the alignment in equal length and keep gaps and codon-aa as 4-tuples
                    
                    // (1). When an AA stands in a position that is not a mutiple of four,  
                    //      add gaps to ensure that the first letter of the 4-tuple be always an AA.
                    
                   ThisLen = ResolvedAlignment[i].length();
 
                    if ((ThisLen % 4) > 0)
                    {
                        for (int TmpSeqNo = 1; TmpSeqNo <=TotalSeq; TmpSeqNo++)
                        {
                           while(ResolvedAlignment[TmpSeqNo].length() % 4 > 0)
                            {
                                ResolvedAlignment[TmpSeqNo] += "-";                            	
                            }
                        }
                    }

                    ResolvedAlignment[i] = (String)(ResolvedAlignment[i] + ThisAA);

                }
                else
                {
                    ThisBase = ThisSymbol.toLowerCase();
                    if (ThisBase.equals("u")) ThisBase = "t";
                    if ("agct".indexOf(ThisBase) + 1 > 0)
                    {
                       ThisCodon = ThisCodon + ThisBase;
                       ThisLen = ResolvedAlignment[i].length();
                        if ((ThisLen % 4) == 0 && ThisCodon.length() > 0 )
                        	
                        //(2). When one or more spaces were inserted between the AA and the codon, a 4-tuple starts with a DNA base 
                        //     add a gap to the first position of the 4-tuple to prevent the base from being taken as an AA.
                        {
                            for (int TmpSeqNo = 1; TmpSeqNo <= TotalSeq; TmpSeqNo++)
                            {
                                ResolvedAlignment[TmpSeqNo] = ResolvedAlignment[TmpSeqNo] + "-";
                            }
                        }
                    }
                    ResolvedAlignment[i] = ResolvedAlignment[i] + ThisBase;
                }
                
                if (ThisCodon.length() == 3) ThisCodon = "";
             }
        }

        //Write to file

        System.out.println("Writting the alignments to file" + nameout);

		BufferedWriter out=new BufferedWriter(new FileWriter(nameout));

        for ( i = 1; i <= TotalSeq; i++)
        {
        	out.write(">" + SeqName[i] + "\r\n");
        	out.write(ResolvedAlignment[i] + "\r\n");
        }
        
        out.close();
        return;
    	}
        catch (IOException errmsg)
        {
           System.out.println("Error in reading or writing CAUSA file! Please check that the file is in correct CAUSA format!"+errmsg);
            return;
        }

    }
	public static void main(String args[]){

		try{
            //accept only one args - the input file name for coding DNA sequences 			
			String input=args[0]+".tmp";
			String output=args[0]+".Clustalw.tmp";
			CAUSA CAUSAobj=new CAUSA();

			// Create Sequence file that is comptabile for running Clustalw
			CAUSAobj.createSeqFile(args[0], input);


			// Run clustalw to align unified sequences
			String matrix="./CDP20-10-Gon250.txt";
			String exe= "clustalw2 -INFILE="+input+" -TYPE=PROTEIN -NEGATIVE=ON -OUTFILE="+output+" -OUTPUT=PIR -PWMATRIX="+matrix+" -PWGAPOPEN=40 -PWGAPEXT=0.2 -MATRIX="+matrix;
			       exe+= " -GAPOPEN=40 -GAPEXT=0.4 -ENDGAPS=NO -GAPDIST=4 -NOPGAP -NOHGAP -hgapresidues=PSNDQEKR -ITERATION=TREE";
			
			System.out.println("\nCalling ClustalW to align unified sequences: \n");   
			System.out.println(exe);

			Process p = Runtime.getRuntime().exec(exe);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            String str;
            
            while(( str = br.readLine()) != null)
            {
                System.out.println(str);
            }

            int exitCode = p.waitFor();
            
            while(( str = br.readLine()) != null)
            {
                System.out.println(str);
            }

            if (exitCode == 0) {
                System.out.println("\nClustal Alignment SUCCESS!\n");
                CAUSAobj.ResolveCAUSA(output, args[0]+".CAUSA.Combined Alignment.fasta");
           } else {
                System.err.println("\nClustal Alignment ERROR! (Error Number:" + exitCode+")\n");
            }
            			
			System.out.println("\nLook for alignment file as: "+args[0]+".CAUSA.fasta\n\n");

		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
			}
	}
}
