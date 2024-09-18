import React, { useState } from 'react';
import axios from 'axios';
import '../styles/ControlPanel.css';

function ControlPanel({ onSort }) {
  const [algorithm, setAlgorithm] = useState('bubble');
  const [dataset, setDataset] = useState('');
  const [loading, setLoading] = useState(false); 
  const [error, setError] = useState(null);      


  const handleSort = async () => {
    const datasetArray = dataset.split(',').map(Number); 

    setLoading(true); 
    setError(null);   

    try {
      const response = await axios.post(`${process.env.REACT_APP_BACKEND_URL}/api/sort`, {
        dataset: datasetArray,
        algorithm,
      });

      onSort(response.data); 
    } catch (error) {
      console.error('Error sorting data:', error);
      setError('Failed to sort dataset. Please try again.');
    } finally {
      setLoading(false); 
    }
  };

  return (
    <div className="control-panel">
      <div>
        <label>Select Sorting Algorithm:</label>
        <select value={algorithm} onChange={(e) => setAlgorithm(e.target.value)}>
          <option value="bubble">Bubble Sort</option>
          <option value="selection">Selection Sort</option>
          <option value="insertion">Insertion Sort</option>
          <option value="merge">Merge Sort</option>
          <option value="quick">Quick Sort</option>
          <option value="heap">Heap Sort</option>
          <option value="shell">Shell Sort</option>
        </select>
      </div>

      <div>
        <label>Input Dataset (comma-separated numbers):</label>
        <input
          type="text"
          value={dataset}
          onChange={(e) => setDataset(e.target.value)}
          placeholder="e.g., 5,3,8,6,2"
        />
      </div>

      <button onClick={handleSort} disabled={loading || !dataset}>
        {loading ? 'Sorting...' : 'Sort'}
      </button>

      {error && <p className="error-message">{error}</p>}
    </div>
  );
}

export default ControlPanel;