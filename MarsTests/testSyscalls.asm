.include "macros.asm"

.data


.text

#criação dos processos
	SyscallFork(Programa1, Programa2, 8, 0, 15)
	SyscallFork(Programa2, FimPrograma2, 10, 0, 15)
	SyscallFork(Idle,Programa1, 6, 0, 15)			

#esclonando o primeiro processo	
	SyscallProcessChange
Idle:
	loop:
	add $zero,$zero,$zero
	j loop

Programa1:
	
	addi $s1, $zero, 1 # valor inicial do contador

	addi $s2, $zero, 10 # valor limite do contador

	loop1: addi $s1, $s1, 1

	beq $s1, $s2, fim1

	#processChange

	j loop1

fim1: SyscallProcessTerminate

Programa2:

	addi $s1, $zero, -1 # valor inicial do contador

	addi $s2, $zero, -10 # valor limite do contador

	loop2: addi $s1, $s1, -1

	beq $s1, $s2, fim2

	#processChange

	j loop2

fim2: SyscallProcessTerminate

FimPrograma2: