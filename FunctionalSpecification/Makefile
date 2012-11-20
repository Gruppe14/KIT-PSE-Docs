# Pflichtenheft Makefile
#
# requirements:
#  * bash for rm parentheses acronym
#  * aspell and aspell-de for spellcheck
#  * ghostscript for optimizing
#
# notes:
#  * glossary is always built
#  * spellcheck is inaccurate, at least supports you
#  * ghostscript command name is only for linux, on Mac/Windows use gsos2/gswin32c


SHELL := /bin/bash
PDFLATEX = pdflatex
GHOSTSCRIPT = gs
TARGET = main


all: $(TARGET).pdf $(TARGET).gls

$(TARGET).pdf: *.tex
	$(PDFLATEX) $(TARGET).tex

$(TARGET).gls: *.tex
	makeglossaries $(TARGET)
	$(PDFLATEX) -interaction=batchmode $(TARGET).tex
	makeglossaries $(TARGET)
	$(PDFLATEX) -interaction=batchmode $(TARGET).tex

optimized: all
	$(GHOSTSCRIPT) -sDEVICE=pdfwrite -dDOPDFMARKS=true -dMaxSubsetPct=100 -dPDFSETTINGS=/printer -dUseCIEColor=true -sOutputFile="Pflichtenheft_optimized.pdf" -dNOPAUSE -dBATCH "$(TARGET).pdf" docinfo.txt

#spell:
#	cat *.tex | aspell --mode=tex --dont-tex-check-comments --lang=de_DE-neu list > $(TARGET).spellcheck

clean:
	rm --force $(TARGET).{aux,glg,glo,gls,ist,dvi,log,out,pdf,toc} Pflichtenheft_optimized.pdf

.PHONY: all clean spell optimized
