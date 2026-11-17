import React, { useState, useEffect } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

function Attendance() {
  const [empid, setEmpid] = useState('');
  const [inTime, setInTime] = useState('');
  const [outTime, setOutTime] = useState('');
  const [comment, setComment] = useState('Regular office check-in');
  const [submitting, setSubmitting] = useState(false);
  const [currentTime, setCurrentTime] = useState(new Date().toLocaleTimeString());
  const navigate = useNavigate();

  useEffect(() => {
    // Set default current local time
    const now = new Date();
    const localIso = new Date(now.getTime() - now.getTimezoneOffset() * 60000).toISOString().slice(0, 16);
    setInTime(localIso);

    // Live clock ticker
    const timer = setInterval(() => {
      setCurrentTime(new Date().toLocaleTimeString());
    }, 1000);

    const storedUser = localStorage.getItem("user");
    if (storedUser) {
      try {
        const u = JSON.parse(storedUser);
        const id = u.emp_id || u.empid || u.empId;
        if (id) {
          setEmpid(id);
        }
      } catch (e) {
        console.error(e);
      }
    }

    return () => clearInterval(timer);
  }, []);

  async function submitAttendance(e) {
    e.preventDefault();
    setSubmitting(true);

    try {
      const response = await fetch("http://localhost:8080/v1/user/attendance/markattendance", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          employee: {
            emp_id: Number(empid)
          },
          inTime: inTime,
          outTime: outTime || null,
          comment: comment
        })
      });

      const message = await response.text();
      alert(message);
      navigate("/dashboard");
    } catch (err) {
      console.error(err);
      alert("Error marking attendance. Make sure backend is running!");
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
              <Link to="/dashboard" className="btn btn-outline-secondary btn-sm px-3">
                Dashboard
              </Link>
            </div>
          </div>
        </nav>

        {/* Attendance Form Container */}
        <div className="container my-auto py-5">
          <div className="row justify-content-center">
            <div className="col-12 col-md-8 col-lg-6 col-xl-5">
              {/* Live Clock Card */}
              <div className="bg-white p-3 rounded-3 border shadow-sm mb-3 text-center">
              <span className="text-muted small text-uppercase fw-semibold" style={{ letterSpacing: '0.5px' }}>
                Current Local Time
              </span>
                <h3 className="fw-bold text-primary mt-1 mb-0">{currentTime}</h3>
                <small className="text-secondary">{new Date().toDateString()}</small>
              </div>

              {/* Form Card */}
              <div className="card shadow-sm border rounded-4 overflow-hidden" style={{ borderColor: '#e2e8f0' }}>
                <div className="bg-white p-4 p-md-5 text-start">
                  <div className="d-flex justify-content-between align-items-center mb-4 pb-2 border-bottom">
                    <div>
                      <h4 className="fw-bold text-dark mb-0">Daily Punch In</h4>
                      <p className="text-muted small mb-0">Record your work check-in</p>
                    </div>
                    <span className="badge bg-primary-subtle text-primary border border-primary-subtle px-3 py-2 rounded-pill fw-semibold">
                    Live
                  </span>
                  </div>

                  <form onSubmit={submitAttendance}>
                    <div className="mb-3">
                      <label className="form-label small fw-semibold text-secondary">Employee ID *</label>
                      <input
                          type="number"
                          className="form-control py-2"
                          value={empid}
                          onChange={(e) => setEmpid(e.target.value)}
                          placeholder="e.g. 200"
                          required
                      />
                    </div>

                    <div className="mb-3">
                      <label className="form-label small fw-semibold text-secondary">In Time (Check-In) *</label>
                      <input
                          type="datetime-local"
                          className="form-control py-2"
                          value={inTime}
                          onChange={(e) => setInTime(e.target.value)}
                          required
                      />
                    </div>

                    <div className="mb-3">
                      <label className="form-label small fw-semibold text-secondary">
                        Out Time (Check-Out) <span className="text-muted fw-normal">(Optional)</span>
                      </label>
                      <input
                          type="datetime-local"
                          className="form-control py-2"
                          value={outTime}
                          onChange={(e) => setOutTime(e.target.value)}
                      />
                    </div>

                    <div className="mb-4">
                      <label className="form-label small fw-semibold text-secondary">Comment / Note</label>
                      <input
                          type="text"
                          className="form-control py-2"
                          value={comment}
                          onChange={(e) => setComment(e.target.value)}
                          placeholder="e.g. Regular office check-in"
                      />
                    </div>

                    <button
                        type="submit"
                        disabled={submitting}
                        className="btn btn-primary w-100 py-2 fw-semibold shadow-sm"
                        style={{ backgroundColor: '#2563eb', borderColor: '#2563eb', borderRadius: '8px' }}
                    >
                      {submitting ? 'Recording Punch...' : 'Submit Attendance'}
                    </button>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>

        <footer className="bg-white border-top py-3 text-center text-muted small mt-auto">
          HRMS Management System • Daily Attendance Punch
        </footer>
      </div>
  );
}

export default Attendance;