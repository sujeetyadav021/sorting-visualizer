import React, { useState } from 'react';
import axios from 'axios';
import ControlPanel from './components/ControlPanel';
import Visualizer from './components/Visualizer';
import './App.css';

function App() {
  const [sortedDataset, setSortedDataset] = useState([]);
  const [loading, setLoading] = useState(false);

  const handleSort = async (data) => {
    setLoading(true);
    try {
      const response = await axios.post(`${process.env.REACT_APP_BACKEND_URL}/api/sort`, data);
      setSortedDataset(response.data.sortedDataset);
    } catch (error) {
      console.error('Error sorting the data', error);
    }
    setLoading(false);
  };

  return (
    <div className="App">
      <h1>Sorting Visualizer</h1>
      <ControlPanel onSort={handleSort} />
      {loading ? <p>Sorting...</p> : <Visualizer dataset={sortedDataset} />}
    </div>
  );
}

export default App;