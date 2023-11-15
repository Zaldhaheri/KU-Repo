	.file	"task4.c"
	.text
	.globl	_scale
	.def	_scale;	.scl	2;	.type	32;	.endef
_scale:
LFB0:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$16, %esp
	movl	12(%ebp), %eax
	sall	$3, %eax
	movl	%eax, -4(%ebp)
	movl	8(%ebp), %eax
	addl	%eax, -4(%ebp)
	addl	$4, -4(%ebp)
	movl	-4(%ebp), %eax
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
LFE0:
	.ident	"GCC: (MinGW.org GCC-6.3.0-1) 6.3.0"
