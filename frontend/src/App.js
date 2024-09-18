import React, { useState } from 'react';
import ControlPanel from './components/ControlPanel';
import Visualizer from './components/Visualizer';
import './App.css';

function App() {
  const [steps, setSteps] = useState([]);       
  const [stepIndex, setStepIndex] = useState(0); 

  
  const handleSort = (sortingSteps) => {
    setSteps(sortingSteps);  
    setStepIndex(0);       

    let i = 0;
    const interval = setInterval(() => {
      setStepIndex(i);      
      i++;
      if (i >= sortingSteps.length) {
        clearInterval(interval); 
      }
    }, 800); 
  };

  return (
    <div className="App">
      <header>
        <h1>Sorting Visualizer</h1>
      </header>

      {/* Main container for Flexbox layout */}
      <div className="main-container">
        {/* Control Panel at the left */}
        <ControlPanel onSort={handleSort} />

        {/* Visualizer at the right */}
        {steps.length > 0 && <Visualizer dataset={steps[stepIndex]} />}
      </div>
    </div>
  );
}

export default App;