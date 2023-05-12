wordcount = 0
linecount = 0
charcount = 0

for line in open("fileprac.txt"):
    linecount += 1
    wordcount += len(line.strip().split())
    charcount += len(line.strip())

print(linecount, wordcount, charcount,)