import React, { useState } from 'react';
import ControlPanel from './components/ControlPanel';
import Visualizer from './components/Visualizer';
import './App.css';

function App() {
  const [dataset, setDataset] = useState([]);
  const [steps, setSteps] = useState([]);
  const [stepIndex, setStepIndex] = useState(0);

  const handleSort = (sortingSteps) => {
    setSteps(sortingSteps);
    setStepIndex(0); // Start from the first step

    // Automatically animate the sorting steps
    let i = 0;
    const interval = setInterval(() => {
      setStepIndex(i);
      i++;
      if (i >= sortingSteps.length) {
        clearInterval(interval);
      }
    }, 500); // Adjust the delay (in ms) for animation
  };

  return (
    <div className="App">
      <h1>Sorting Visualizer</h1>
      <ControlPanel onSort={handleSort} />
      {steps.length > 0 && <Visualizer dataset={steps[stepIndex]} />}
    </div>
  );
}

export default App;