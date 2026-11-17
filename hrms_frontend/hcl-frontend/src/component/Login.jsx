import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate, Link } from 'react-router-dom';

function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [submitting, setSubmitting] = useState(false);
  const navigate = useNavigate();

  async function handleLogin(e) {
    e.preventDefault();
    setSubmitting(true);
    try {
      const response = await fetch("http://localhost:8080/v1/user/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          email: email,
          password: password
        })
      });

      if (response.ok) {
        const user = await response.json();
        localStorage.setItem("user", JSON.stringify(user));
        navigate("/dashboard");
      } else {
        const errMsg = await response.text();
        alert(errMsg || "Invalid email or password");
      }
    } catch (err) {
      console.error(err);
      alert("Error logging in. Please check if backend is running.");
    } finally {
      setSubmitting(false);
    }
  }

  return (
    <div style={{ backgroundColor: '#f8fafc', minHeight: '100vh', display: 'flex', flexDirection: 'column' }}>
      {/* Top Navbar */}
      <nav className="navbar navbar-light bg-white border-bottom shadow-sm px-4 py-3">
        <div className="container d-flex justify-content-between align-items-center">
          <Link to="/" className="d-flex align-items-center gap-2 text-decoration-none">
            <div style={{
              width: '36px',
              height: '36px',
              backgroundColor: '#2563eb',
              color: '#ffffff',
              borderRadius: '8px',
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'center',
              fontWeight: 'bold',
              fontSize: '18px'
            }}>
              H
            </div>
            <span className="fw-bold text-dark fs-5 mb-0" style={{ letterSpacing: '0.5px' }}>
              HRMS <span style={{ color: '#2563eb' }}>Portal</span>
            </span>
          </Link>
          <div className="d-flex gap-2">
            <Link to="/" className="btn btn-outline-secondary btn-sm px-3">
              Home
            </Link>
            <Link to="/registeration" className="btn btn-outline-primary btn-sm px-3">
              Register
            </Link>
          </div>
        </div>
      </nav>

      {/* Login Card */}
      <div className="container my-auto py-5">
        <div className="row justify-content-center">
          <div className="col-12 col-sm-10 col-md-7 col-lg-5 col-xl-4">
            <div className="card shadow-sm border rounded-4 overflow-hidden" style={{ borderColor: '#e2e8f0' }}>
              <div className="bg-white p-4 p-sm-5 text-start">
                <div className="text-center mb-4">
                  <div style={{
                    width: '46px',
                    height: '46px',
                    backgroundColor: '#eff6ff',
                    color: '#2563eb',
                    borderRadius: '12px',
                    display: 'inline-flex',
                    alignItems: 'center',
                    justifyContent: 'center',
                    fontWeight: 'bold',
                    fontSize: '22px',
                    marginBottom: '12px'
                  }}>
                    🔐
                  </div>
                  <h4 className="fw-bold text-dark mb-1">Employee Sign In</h4>
                  <p className="text-muted small">Enter your credentials to access your dashboard</p>
                </div>

                <form onSubmit={handleLogin}>
                  <div className="mb-3">
                    <label className="form-label small fw-semibold text-secondary">Email Address</label>
                    <input
                      type="email"
                      className="form-control py-2"
                      placeholder="name@company.com"
                      value={email}
                      onChange={(e) => setEmail(e.target.value)}
                      required
                    />
                  </div>

                  <div className="mb-3">
                    <label className="form-label small fw-semibold text-secondary">Password</label>
                    <input
                      type="password"
                      className="form-control py-2"
                      placeholder="Enter your password"
                      value={password}
                      onChange={(e) => setPassword(e.target.value)}
                      required
                    />
                  </div>

                  <div className="d-flex justify-content-between align-items-center mb-4">
                    <div className="form-check">
                      <input type="checkbox" className="form-check-input" id="rememberMe" />
                      <label className="form-check-label small text-secondary" htmlFor="rememberMe">Remember me</label>
                    </div>
                  </div>

                  <button
                    type="submit"
                    disabled={submitting}
                    className="btn btn-primary w-100 py-2 fw-semibold shadow-sm"
                    style={{ backgroundColor: '#2563eb', borderColor: '#2563eb', borderRadius: '8px' }}
                  >
                    {submitting ? 'Authenticating...' : 'Sign In'}
                  </button>

                  <p className="mt-4 mb-0 text-center small text-muted">
                    Don't have an account? <Link to="/registeration" className="text-primary text-decoration-none fw-semibold">Register here</Link>
                  </p>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>

      <footer className="bg-white border-top py-3 text-center text-muted small mt-auto">
        HRMS Management System • Secure Authentication
      </footer>
    </div>
  );
}

export default Login;
