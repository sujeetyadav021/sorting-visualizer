import React from 'react';
import '../styles/Visualizer.css';

function Visualizer({ dataset }) {
  return (
    <div className="visualizer">
      {dataset.map((value, idx) => (
        <div
          key={idx}
          className="bar"
          style={{ height: `${value * 5}px` }}
          title={value}
        ></div>
      ))}
    </div>
  );
}

export default Visualizer;