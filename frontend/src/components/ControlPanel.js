import React, { useState } from 'react';

function ControlPanel({ onSort }) {
  const [algorithm, setAlgorithm] = useState('quick');
  const [dataset, setDataset] = useState('');

  const handleSort = () => {
    const datasetArray = dataset.split(',').map(Number);
    onSort({ dataset: datasetArray, algorithm });
  };

  return (
    <div>
      <div>
        <label>Select Sorting Algorithm: </label>
        <select value={algorithm} onChange={(e) => setAlgorithm(e.target.value)}>
          <option value="quick">Quick Sort</option>
          <option value="merge">Merge Sort</option>
          {/* Add more algorithms if needed */}
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
