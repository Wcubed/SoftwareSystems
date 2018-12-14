# Week1

## 1.3
Works

## 1.4
We get errors.

## 1.6

### 1.2
An enum.

### 2.4
The lamp should have three states: off, low, medium and high.
The user should be able to read and write this state.

## 1.7
See ThreeWayLight

## 1.8
See ThreeWayLightTest
Test is successfull.

## 1.9
```
public bool passed() {
    return score >= 70;
}
```

No conditional statements needed.

## 1.10
### 4.7
```
public double calculatePay() {
	if (hours < OVERTIME) {
		return hours * rate;
	} else {
		double basePay = OVERTIME * rate;
		double overtime = (hours - OVERTIME) * rate * 1.5;
		return basePay + overtime;
	}
}
```
### 4.13
For the code, see `DollarsAndCentsCounter.java`.
A subtract method could potentially ask to subtract more money than there is in the counter.
So we need a guard for this.

## 1.11
See `Guest.java`.
## 1.12
All unit tests fail. Which is logical, because the Guest class has nothing implemented yet.

## 1.13
See `Guest.java`.
## 1.14
Anything that is public facing about the class is included in the documentation.
Basically, it is an outline of the API of the class.
This is handy if you want to, say, use the class :).

## 1.15
The String is contained in `java.lang`.
There are 14 constructors, of which 2 are deprecated.
There are 30 factory methods, of which 15 return a static String.

## 1.16
See `Guest.java`.
## 1.17
Gives an error as expected.
## 1.18
See `Guest.java`.

## 1.19
You need to know the current password to be able to change the password.
Making the initial password be a defined constant makes it explicit what the initial password will be.
Using an empty string `""` could lead to confusion as to how to set the password for the first time. And it makes it hard to see which code is actually using the initial password.

## 1.20
Other classes need to be able to set the password to something else than the initial one. They need the current password to set the new one, so if that was private, no one would be able to change the password.

## 1.21
See `Password.java`.
## 1.22
See `Password.java`.
