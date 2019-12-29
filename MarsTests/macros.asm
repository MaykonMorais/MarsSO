.data
	errorString: .asciiz "Erro! numero negativo"

.text
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


store_var: # manipulate variables


