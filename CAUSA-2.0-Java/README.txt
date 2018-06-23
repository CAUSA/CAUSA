===============================================
This software is released under GNU/GPL license
Copyright (c) 2014, Ocean University of China
===============================================
Written by:  
Xiaolong Wang* @ Ocean University of China
Email: xiaolong@ouc.edu.cn
                 
website: http://www.DnaPlusPro.com
===============================================
CAUSA: Codon and Amino-acid Unified Sequence Alignments

This is a multiple sequence aligner, which uses both DNA sequence information its corresponding protein sequence information.

How to install?

Pre-requirements:

1. Clustalw2 installation.
2. Java installation.
3. gcj installation (optional).


Step1: unzip the java file in Linux using: 

$ mkdir CAUSA-2
$ mv CAUSA-2-Linux.zip ./CAUSA-2
$ cd CAUSA-2
$ unzip CAUSA-2-Linux.zip

Step2: compile the CAUSA source code using gcj or javac:

$ gcj --main=CAUSA CAUSA.java -o CAUSA

or

$ javac CAUSA.java

How to run?

if it was compiled with gcj:

$ CAUSA <InputFile (CDSs in fasta format)>

or if it was compiled with javac:

$java CAUSA <InputFile (CDSs in fasta format)>

Note: 
1. Inputfile must be an mRNA/cDNA sequence file in fasta format, containing at leat 3 coding DNA sequences (CDSs). 
2. The sequences will be translated ONLY in the first ORF;
3. The output file named as "InputFile.CombinedAlignment.fasta" is the resulting Combined Alignment, which is also in fasta format. 

It can be opened and viewed using the windows C# version of CAUSA.exe, which is available in our website http://www.DnaPlusPro.com free of charge.

It will output a DNA alignment and a protein alignment. The DNA alignment and the protein alignment are always fully consistent with each other, while they are often inconsistent with each other in other software which align DNA and protein separately.

The DNA alignment and the protein alignment can be used other software for further phylogenetic, structure or evolutionary analysis. You will get some conclusions that are different from, more consistent and better than, traditional DNA, protein or codon alignments.



Introduction

CAUSA: Codon and Amino-acid Unified Sequence Alignments

Structurally and Evolutionarily Consistent Alignment of Closely-related Proteins

Multiple sequence alignment (MSA) has been widely used for evolutionary analysis and structures modeling of proteins. Traditionally, proteins and their coding DNA sequences (CDSs) are aligned and analyzed separately, while often drastically different conclusions were drawn on a same set of data.

Here we present a new alignment strategy, codon and amino acid unified sequence alignment (CAUSA), which aligns protein sequences and their CDSs in a unified manner. Taken every codon as a whole but divisible unit, CAUSA allows internal gap placement, and enlarges the information content of MSA through a Rosetta effect.

CAUSA not only gives highly accurate alignment suitable for both homology structures modeling and evolutionary analysis of closely-related proteins, but also explains how base/AA substitutions, insertions and deletions edit coding DNA sequences and drive protein structure evolution, through some unexplored ways of codons changes, including codon fusion, codon splitting and insertional partial frame shift.

Using the envelop protein (gp120) of the human immune deficiency virus (HIV) as a model, it is demonstrated that CAUSA is evolutionarily and structurally more accurate and consistent than traditional DNA, protein or codon level alignments.

In addition, CAUSA is computationally more efficient than codon level alignment methods.
