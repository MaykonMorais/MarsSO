.data
	errorString: .asciiz "Erro! numero negativo"

.text

.macro SyscallFork(%a0, %k0, %k1) # create a process
	li $v0, 19 # load number syscall
	la $a0, %a0 # load initial adress
	la $k0, %k0
	
	subi $k0, $k0, 4
	li $k1, %k1 # define priority
	
	syscall
.end_macro

.macro SyscallProcessChange 
	li $v0, 20
	syscall
.end_macro

.macro SyscallProcessTerminate
	li $v0, 21
	syscall
.end_macro

done: #para finalizar programa
	li $v0, 10
	syscall	

print_int: #para imprimir inteiro
      li $v0, 1		#imprimir inteiro
      syscall
      jr $ra	

print_char: #para imprimir caracter
	li $v0, 11
	syscall
	jr $ra
	
print_string: #para imprimir 
	li $v0, 4
	syscall
	jr $ra

read_int: #para leitura de inteiro
	addi $sp, $sp, -4
        sw $ra, 0($sp)

	li $v0, 5
	syscall
	jal return
	
	lw $ra, 0($sp) # restore $ra register 
	addi $sp, $sp, 4
	
	jr $ra
	
read_char: #para leitura de inteiro
	li $v0, 12
	syscall
	jr $ra
	
read_string: #para leitura de string
	li $v0, 8 
	syscall
	jr $ra

return: 
	blt $v0, 0, exit2 # compare if number is less than 0
	jr $ra
	#jal done # return to the end of program? this doesn't make sense 
	
exit2: 	
	la $a0, errorString # load adress message
	jal print_string # show error message
	jal done # stop program 
	
load_var: # manipulate variables
	lw $v0, 0($a0) # carrega o valor de a1(endereco da label) em v0
	jr $ra

store_var: # manipulate variables
	sw $a0, 0($v0) 
	jr $ra
