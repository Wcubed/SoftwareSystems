# Week3

## 3.5
Not all functions can be integrated. Adding it to the Function interface would imply that all functions can be integrated, which is not true.

## 3.7
What to do with these errors:
`Sum is a raw type. References to generic type Sum<T> should be parameterized`
How to do the integrating to `LinearProduct`?

## 3.12
Is having this: `public static final String INITPASS = "SFDJKLS";` in the interface indeed how it is supposed to be implemented?

If `testPassword` is overwritten. You can no longer change the password when the password has expired. Because that function is also used in the password change function to see if the old password you give is correct.

## 3.16
Is specifying `public String toString();` in the `Bill.Item` interface necessary? Or is it simply neat to do it, and will it also work without. As `Object` already has a `toString` method.
