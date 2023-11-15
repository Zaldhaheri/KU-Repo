	.file	"task3.c"
	.text
	.globl	switch_eg
	.type	switch_eg, @function
switch_eg:
.LFB0:
	.cfi_startproc
	endbr64
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	movq	%rdi, -24(%rbp)
	movq	%rsi, -32(%rbp)
	movq	%rdx, -40(%rbp)
	movq	$1, -8(%rbp)
	cmpq	$6, -24(%rbp)
	jg	.L2
	cmpq	$5, -24(%rbp)
	jge	.L3
	cmpq	$3, -24(%rbp)
	je	.L4
	cmpq	$3, -24(%rbp)
	jg	.L2
	cmpq	$1, -24(%rbp)
	je	.L5
	cmpq	$2, -24(%rbp)
	je	.L6
	jmp	.L2
.L5:
	movq	-32(%rbp), %rax
	imulq	-40(%rbp), %rax
	movq	%rax, -8(%rbp)
	jmp	.L7
.L6:
	movq	-32(%rbp), %rax
	cqto
	idivq	-40(%rbp)
	movq	%rax, -8(%rbp)
.L4:
	movq	-40(%rbp), %rax
	addq	%rax, -8(%rbp)
	jmp	.L7
.L3:
	movq	-40(%rbp), %rax
	subq	%rax, -8(%rbp)
	jmp	.L7
.L2:
	movq	$2, -8(%rbp)
.L7:
	movq	-8(%rbp), %rax
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE0:
	.size	switch_eg, .-switch_eg
	.ident	"GCC: (Ubuntu 11.4.0-1ubuntu1~22.04) 11.4.0"
	.section	.note.GNU-stack,"",@progbits
	.section	.note.gnu.property,"a"
	.align 8
	.long	1f - 0f
	.long	4f - 1f
	.long	5
0:
	.string	"GNU"
1:
	.align 8
	.long	0xc0000002
	.long	3f - 2f
2:
	.long	0x3
3:
	.align 8
4:
