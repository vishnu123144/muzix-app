import React from 'react'
import './Home.css';
import Header from '../Header/Header';
import Footer from '../Footer/Footer';
export default function Home() {
    return (
        <div>
            <Header />
            <div>
                <section>
                    <container>
                        <h5 class="text-uppercase">Music</h5>
                        <h1 class="text-uppercase">Play!</h1>
                    </container>
                </section>
            </div>
            <Footer />
        </div>
    )
}
