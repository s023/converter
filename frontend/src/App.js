import './App.css';

import React, { useState } from 'react';

function App() {
  const [input, setInput] = useState('');
  const [type, setType] = useState('decimal');
  const [result, setResult] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch(`/api/convert/${type}/${input}`);
      const data = await response.text();
      setResult(data);
    } catch (error) {
      console.error('Error:', error);
      setResult('Error occurred');
    }
  };

  return (
      <div className="App">
        <h1>Number Converter</h1>
        <form onSubmit={handleSubmit}>
          <label>
            Input:
            <input
                type="text"
                value={input}
                onChange={(e) => setInput(e.target.value)}
            />
          </label>
          <br />
          <label>
            Type:
            <select value={type} onChange={(e) => setType(e.target.value)}>
              <option value="decimal">Decimal</option>
              <option value="binary">Binary</option>
            </select>
          </label>
          <br />
          <button type="submit">Convert</button>
        </form>
        {result && (
            <div>
              <h2>Result:</h2>
              <p>{result}</p>
            </div>
        )}
      </div>
  );
}

export default App;

