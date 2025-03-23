import { useState } from "react";
import { Moon, Sun } from "lucide-react";
import { motion } from "framer-motion";

function App() {
  const [darkMode, setDarkMode] = useState(true);

  return (
    <div className={darkMode ? "bg-black text-white" : "bg-white text-black"}>
      {/* Header */}
      <header className="flex justify-between items-center px-10 py-5 bg-gray-900">
        <h1 className="text-2xl font-bold">MiddleClassTraveller</h1>
        <nav>
          <ul className="flex space-x-6">
            <li className="hover:text-green-400">Why Us</li>
            <li className="hover:text-green-400">Booking</li>
            <li className="hover:text-green-400">Contact</li>
          </ul>
        </nav>
        <button onClick={() => setDarkMode(!darkMode)}>
          {darkMode ? <Sun size={24} /> : <Moon size={24} />}
        </button>
      </header>

      {/* Hero Section */}
      <section className="text-center py-20">
        <motion.h2 
          className="text-4xl font-bold"
          initial={{ opacity: 0, y: -20 }}
          animate={{ opacity: 1, y: 0 }}
        >
          Affordable Hotels for Every Traveller
        </motion.h2>
        <div className="mt-6 space-x-4">
          <button className="px-6 py-2 bg-green-500 rounded-lg">Explore Hotels</button>
          <button className="px-6 py-2 border rounded-lg">Quick Book</button>
        </div>
      </section>

      {/* Footer */}
      <footer className="py-5 bg-gray-900 text-center">
        <p>© 2025 MiddleClassTraveller. All Rights Reserved.</p>
      </footer>
    </div>
  );
}

export default App;
