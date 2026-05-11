<div align="center">
  <h1>🔤 Palindrome Pairs</h1>
  <p>
    <strong>Determine whether there exists a pair of indices (i, j) such that their concatenation forms a palindrome.</strong>
  </p>
</div>

<hr>

<h2>📝 Problem Statement</h2>
<p>
  Given an array <code>arr[]</code> consisting of <code>n</code> strings. Determine whether there exists a pair of indices <code>(i, j)</code> such that <code>i ≠ j</code> and the concatenation <code>arr[i] + arr[j]</code> forms a palindrome.
</p>
<p>
  Return <code>true</code> if such a pair exists; otherwise, return <code>false</code>.
</p>
<p>
  <i>Note: A string is considered a palindrome if it reads the same forward and backward.</i>
</p>

<h3>💡 Examples</h3>

<table>
  <thead>
    <tr>
      <th>Input Array</th>
      <th>Output</th>
      <th>Explanation</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><code>["geekf", "geeks", "or", "keeg", "abc", "bc"]</code></td>
      <td><b>true</b></td>
      <td>There is a pair "geekf" and "keeg". Their concatenation "geekfkeeg" is a palindrome.</td>
    </tr>
    <tr>
      <td><code>["abc", "xyxcba", "geekst", "or", "bc"]</code></td>
      <td><b>true</b></td>
      <td>There is a pair "abc" and "xyxcba". Their concatenation "abcxyxcba" is a palindrome.</td>
    </tr>
    <tr>
      <td><code>["aa"]</code></td>
      <td><b>false</b></td>
      <td>There is only one string present, so the output is false.</td>
    </tr>
  </tbody>
</table>

<h3>⚙️ Constraints</h3>
<ul>
  <li><code>1 ≤ n ≤ 2*10^4</code></li>
  <li><code>1 ≤ |arr[i]| ≤ 10</code></li>
</ul>

<hr>

<h2>🧠 Algorithm Explanation</h2>

<p>
  Since <code>n</code> can be up to <code>20,000</code>, a brute-force approach checking all pairs <code>O(N²)</code> would result in <b>Time Limit Exceeded (TLE)</b>. However, the maximum length of each string is very small (<code>L ≤ 10</code>). This allows us to optimize the solution using a <b>HashMap</b> to achieve an <code>O(N &times; L²)</code> time complexity.
</p>

<h3>Step-by-Step Logic</h3>
<ol>
  <li>
    <b>Store Strings:</b> First, we insert all strings and their indices into a <code>HashMap</code>. This allows us to look up any string in <code>O(1)</code> time.
  </li>
  <li>
    <b>Split Each String:</b> We iterate over every string <code>s</code> in the array. For each string, we split it into two parts at every possible index: <code>left</code> and <code>right</code>.
  </li>
  <li>
    <b>Check Left Palindrome:</b> If the <code>left</code> part is a palindrome, we check if the reverse of the <code>right</code> part exists in the array. If it does (and it's not the exact same element), combining the reverse of the right part with our current string will form a palindrome!
    <br><i>Example:</i> <code>s = "geekf"</code> &rarr; <code>left = "g"</code> (palindrome), <code>right = "eekf"</code>. Reverse of right is <code>"fkee"</code>. If we find <code>"fkee"</code>, then <code>"fkee" + "geekf"</code> forms a palindrome.
  </li>
  <li>
    <b>Check Right Palindrome:</b> Similarly, if the <code>right</code> part is a palindrome, we check if the reverse of the <code>left</code> part exists in the array.
  </li>
  <li>
    <b>Return Result:</b> If any valid pair is found during these checks, return <code>true</code> immediately. If the loop completes without finding a pair, return <code>false</code>.
  </li>
</ol>

<h3>⏱️ Complexity</h3>
<ul>
  <li><b>Time Complexity:</b> <code>O(N &times; L²)</code> where <code>N</code> is the number of strings and <code>L</code> is the max string length. The <code>L²</code> comes from iterating over the length of the string and checking for palindromes.</li>
  <li><b>Space Complexity:</b> <code>O(N)</code> to store the strings in the HashMap.</li>
</ul>
