import React from 'react';
import '../styles/Visualizer.css';

function Visualizer({ dataset }) {
    return (
      <div className="visualizer">
        {dataset.map((value, idx) => (
          <div key={idx} className="bar-container">
            <div
              className="bar"
              style={{ height: `${value * 5}px` }} 
            ></div>
            <div className="bar-value">{value}</div>
          </div>
        ))}
      </div>
    );
  }
  
  export default Visualizer;