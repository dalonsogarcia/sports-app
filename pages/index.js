import Layout from '../components/Layout.js'
import Link from 'next/link'
import fetch from 'isomorphic-unfetch'

const Index = (props) => (
  <Layout>
    <h1>Sports Organizer Homepage</h1>
    <ul>
      <li>
        <Link href={`/clans`}>
          <a>Browse clans</a>
        </Link>
        <Link href={'/'}>
          <a>Become a member</a>
        </Link>
      </li>
    </ul>
  </Layout>
)

export default Index
