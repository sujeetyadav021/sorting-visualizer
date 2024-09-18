import React, { useState } from 'react';
import ControlPanel from './components/ControlPanel';
import Visualizer from './components/Visualizer';
import './App.css';

function App() {
  const [steps, setSteps] = useState([]);       // Stores sorting steps
  const [stepIndex, setStepIndex] = useState(0); // Tracks current step in sorting

  // Handles the sorting process and animates the steps
  const handleSort = (sortingSteps) => {
    setSteps(sortingSteps);  // Set the sorting steps
    setStepIndex(0);         // Reset step index to start

    let i = 0;
    const interval = setInterval(() => {
      setStepIndex(i);       // Update step index every 500ms
      i++;
      if (i >= sortingSteps.length) {
        clearInterval(interval); // Stop when all steps are visualized
      }
    }, 500); // 500ms per step (adjust speed here)
  };

  return (
    <div className="App">
      <header>
        <h1>Sorting Visualizer</h1>
      </header>

      {/* Control Panel to initiate sorting */}
      <ControlPanel onSort={handleSort} />

      {/* Visualize only if there are steps to display */}
      {steps.length > 0 && <Visualizer dataset={steps[stepIndex]} />}
    </div>
  );
}

export default App;