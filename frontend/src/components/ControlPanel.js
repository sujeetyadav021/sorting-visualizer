import React, { useState } from 'react';
import axios from 'axios';

function ControlPanel({ onSort }) {
  const [algorithm, setAlgorithm] = useState('bubble');
  const [dataset, setDataset] = useState('');

  const handleSort = async () => {
    const datasetArray = dataset.split(',').map(Number);

    try {
      const response = await axios.post(`${process.env.REACT_APP_BACKEND_URL}/api/sort`, {
        dataset: datasetArray,
        algorithm
      });

      onSort(response.data);
    } catch (error) {
      console.error('Error sorting data:', error);
    }
  };

  return (
    <div>
      <div>
        <label>Select Sorting Algorithm: </label>
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
        <label>Input Dataset (comma-separated numbers): </label>
        <input
          type="text"
          value={dataset}
          onChange={(e) => setDataset(e.target.value)}
          placeholder="e.g., 5,3,8,6,2"
        />
      </div>

      <button onClick={handleSort}>Sort</button>
    </div>
  );
}

export default ControlPanel;