.include "macros.asm"

# Calcula f = (g+h)-(i+j)
.data
      str1: .asciiz "Digite o valor de g: "
      str2: .asciiz "Digite o valor de h: "
      str3: .asciiz "Digite o valor de i: "
      str4: .asciiz "Digite o valor de j: "
      f: .word 

.text
.globl main
main: 
      la $a0, str1 # print str1
      jal print_string
      jal read_int # read first number
      move $s1, $v0 # set value of variable g
      
      la $a0, str2 # print str2
      jal print_string
      jal read_int # read second number
      move $s2, $v0 # set value of variable h
      
      la $a0, str3 # print str3
      jal print_string
      jal read_int # read third number
      move $s3, $v0 # set value of variable i
            
      la $a0, str4 # print str4
      jal print_string
      jal read_int # read fourth number
      move $s4, $v0 # set value of variable j
      
      #Realizando o calculo
      add $t0, $s1, $s2	#sum of g and h
      add $t1, $s3, $s4	#sum of i and j
      sub $s0, $t0, $t1	#f = (gs+h)-(i+j)
      
      #store result on memory
      la  $t0, f        # carrega o endereco de f em $t0
      sw $s0, 0($t0)	# armazena o valor
      
      add $a0, $s0, $zero #copiando o valor de $s0 para $a0
      
      jal print_int
      
      jal done
      
	   
