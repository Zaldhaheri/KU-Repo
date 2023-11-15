	.file	"task3.c"
	.text
	.globl	_func
	.def	_func;	.scl	2;	.type	32;	.endef
_func:
LFB0:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$32, %esp
	movl	8(%ebp), %eax
	movl	%eax, -4(%ebp)
	movl	12(%ebp), %eax
	movl	%eax, -8(%ebp)
	movl	16(%ebp), %eax
	movl	%eax, -12(%ebp)
	movl	-8(%ebp), %eax
	orl	-12(%ebp), %eax
	movl	%eax, -16(%ebp)
	movl	-8(%ebp), %eax
	sarl	$9, %eax
	movl	%eax, -20(%ebp)
	movl	-8(%ebp), %eax
	subl	-20(%ebp), %eax
	movl	%eax, -24(%ebp)
	movl	-4(%ebp), %eax
	andl	$252645135, %eax
	movl	%eax, -28(%ebp)
	movl	-24(%ebp), %eax
	movl	%eax, -32(%ebp)
	movl	-32(%ebp), %eax
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
LFE0:
	.ident	"GCC: (MinGW.org GCC-6.3.0-1) 6.3.0"
