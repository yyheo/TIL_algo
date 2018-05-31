num = int(input())
a = 0
b = 1

for i in range(2, num+1):
    tmp = b
    b = a + b
    a = tmp

print(b)
